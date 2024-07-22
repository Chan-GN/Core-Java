package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {

    private String name;
    private int age;
    private String city;
    private String occupation;

    public Person(String name, int age, String city, String occupation) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, city='%s', occupation='%s'}", name, age, city, occupation);
    }

}

public class StreamPractice {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "New York", "Engineer"),
                new Person("Bob", 30, "San Francisco", "Designer"),
                new Person("Charlie", 35, "London", "Manager"),
                new Person("David", 28, "New York", "Developer"),
                new Person("Eve", 22, "Paris", "Student"),
                new Person("Frank", 40, "Tokyo", "Executive"),
                new Person("Grace", 32, "Sydney", "Teacher"),
                new Person("Henry", 45, "Berlin", "Researcher"),
                new Person("Ivy", 27, "Toronto", "Artist"),
                new Person("Jack", 33, "New York", "Lawyer")
        );

        // 나이가 30세 이상인 사람의 수
        long c = people.stream()
                .filter((p) -> p.getAge() >= 30)
                .count();

        // 모든 사람의 이름만 추출하여 List<String>으로 수집
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();

        // 나이순으로 정렬하여 가장 어린 3명의 정보를 출력
        people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .limit(3)
                .forEach(System.out::println);

        // 모든 사람의 이름을 문자 단위로 분리하고, 중복을 제거한 후 정렬하여 출력
        people.stream()
                .map(p -> p.getName().split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // 도시별로 사람들을 그룹화하고, 각 도시의 인원수를 출력
        Map<String, Long> cityCount = people.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        cityCount.forEach((city, count) -> System.out.println(city + ": " + count));

        // 모든 사람의 나이 합계
        Integer sum = people.stream()
                .map(Person::getAge)
                .reduce(0, (a, b) -> a + b);

        // 30세를 기준으로 두 그룹으로 나누고, 각 그룹의 평균 나이를 계산
        Map<Boolean, Double> ageGroups = people.stream()
                .collect(Collectors.partitioningBy(
                        p -> p.getAge() > 30,
                        Collectors.averagingDouble(Person::getAge)));
        System.out.println("30세 초과 그룹의 평균 나이: " + ageGroups.get(true));
        System.out.println("30세 이하 그룹의 평균 나이: " + ageGroups.get(false));

        // 가장 나이 많은 사람과 가장 어린 사람
        Person oldest = people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);
        Person youngest = people.stream()
                .min(Comparator.comparingInt(Person::getAge))
                .orElse(null);
        System.out.println("가장 나이 많은 사람: " + oldest);
        System.out.println("가장 어린 사람: " + youngest);

        // 중복 제거한 직업 알파벳순 정렬
        List<String> uniqueOccupations = people.stream()
                .map(Person::getOccupation)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("중복 제거 및 정렬된 직업: " + uniqueOccupations);

        // anyMatch, allMatch, noneMatch 사용
        boolean has20s = people.stream().anyMatch(p -> p.getAge() >= 20 && p.getAge() < 30);
        boolean allAlphabetic = people.stream().allMatch(p -> p.getName().matches("[a-zA-Z]+"));
        boolean noSeniors = people.stream().noneMatch(p -> p.getAge() >= 60);

        System.out.println("20대가 한 명이라도 있나요? " + has20s);
        System.out.println("모든 이름이 알파벳으로만 이루어져 있나요? " + allAlphabetic);
        System.out.println("60세 이상인 사람이 없나요? " + noSeniors);
    }

}