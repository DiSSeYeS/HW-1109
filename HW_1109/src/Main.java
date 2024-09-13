import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        // Задача 1

        Person Andrew = new Person("Andrew", 20, "male");
        Andrew.displayInfo();
        System.out.println();

        // Задача 2

        Worker worker = new Worker("John", 44, "male", 50000);
        Manager manager = new Manager("Michael", 30, "male", 65000);
        manager.addSubordinate(worker);
        System.out.println();

        // Задача 3

        Cat cat = new Cat();
        cat.makeSound();
        System.out.println();

        // Задача 4

        Car car = new Car();
        car.move();
        System.out.println();

        // Задача 5

        Book book1 = new Book("Мастер и маргарита", "Михаил Булгаков", 1928);
        Book book2 = new Book("Война и Мир", "Лев Толстой", 1867);
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        for (var item : library.searchByAuthor("Михаил Булгаков")){
            System.out.println(item.title);
        }
        System.out.println();

        // Задача 6

        BankAccount account = new BankAccount("12002", 5000);
        account.deposit(3000);
        account.withdraw(2000);

        // Задача 7

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        // Задача 8

        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(10, 15);

        System.out.println(circle.getArea());
        System.out.println(rectangle.getArea());
        System.out.println();

        // Задача 9

        Dog2 dog2 = new Dog2();
        dog2.move();
        System.out.println();

        // Задача 10

        Student student1 = new Student("Michael", "2", 5);
        Student student2 = new Student("George", "3", 4);
        Student student3 = new Student("Sophia", "1", 3);

        University university = new University();
        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);

        for (var item : university.filterByGrade(5)){
            System.out.println(item.name);
        }

        // Задача 11 WIP



        // Задача 12 WIP



        // Задача 13 WIP



        // Задача 14 WIP



        // Задача 15 WIP



        // Задача 16 WIP



        // Задача 17 WIP



        // Задача 18 WIP



        // Задача 19 WIP



        // Задача 20 WIP
    }

    // Задача 1

    public static class Person {
        private String name;
        private int age;
        private final String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public void displayInfo() {
            System.out.println("Name: " + name + ",\nAge: " + age + ",\nGender: " + gender);
        }

        public void increaseAge() {
            age++;
        }

        public void changeName(String newName) {
            this.name = newName;
        }
    }

    // Задача 2

    public static class Worker extends Person {
        private final double salary;

        public Worker(String name, int age, String gender, double salary) {
            super(name, age, gender);
            this.salary = salary;
        }
    }

    public static class Manager extends Worker {
        private final List<Worker> subordinates;

        public Manager(String name, int age, String gender, double salary) {
            super(name, age, gender, salary);
            this.subordinates = new ArrayList<>();
        }

        public void addSubordinate(Worker worker) {
            subordinates.add(worker);
        }

    }

    // Задача 3

    interface Animal {
        void makeSound();
    }

    static class Dog implements Animal {
        public void makeSound() {
            System.out.println("Woof");
        }
    }

    static class Cat implements Animal {
        public void makeSound() {
            System.out.println("Meow");
        }
    }

    static class Cow implements Animal {
        public void makeSound() {
            System.out.println("Moo");
        }
    }

    // Задача 4

    static abstract class Transport {
        public abstract void move();
    }

    static class Car extends Transport {
        public void move() {
            System.out.println("Car is moving");
        }
    }

    static class Bike extends Transport {
        public void move() {
            System.out.println("Bike is moving");
        }
    }

    // Задача 5

    static class Book {
        private final String title;
        private final String author;
        private final int year;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }

    }

    static class Library {
        private final List<Book> books;

        public Library() {
            books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public List<Book> searchByAuthor(String author) {
            return books.stream()
                    .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                    .collect(Collectors.toList());
        }

        public List<Book> searchByYear(int year) {
            return books.stream()
                    .filter(book -> book.getYear() == year)
                    .collect(Collectors.toList());
        }
    }

    // Задача 6

    static class BankAccount {
        private final String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }

    }

    // Задача 7

    static class Counter {
        private static int count = 0;

        public Counter() {
            count++;
        }

        public static int getCount() {
            return count;
        }
    }

    // Задача 8

    static abstract class Shape {
        public abstract double getArea();
    }

    static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Shape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return width * height;
        }
    }

    // Задача 9

    static class Animal2 {
        public void move() {
            System.out.println("Animal is moving");
        }
    }

    static class Fish2 extends Animal2 {
        public void move() {
            System.out.println("Fish is swimming");
        }
    }

    static class Bird2 extends Animal2 {
        public void move() {
            System.out.println("Bird is flying");
        }
    }

    static class Dog2 extends Animal2 {
        public void move() {
            System.out.println("Dog is running");
        }
    }

    // Задача 10

    static class Student {
        private final String name;
        private final String group;
        private final double grade;

        public Student(String name, String group, double grade) {
            this.name = name;
            this.group = group;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }
    }

    static class University {
        private final List<Student> students;

        public University() {
            students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public List<Student> sortByName() {
            return students.stream()
                    .sorted(Comparator.comparing(Student::getName))
                    .collect(Collectors.toList());
        }

        public List<Student> filterByGrade(double threshold) {
            return students.stream()
                    .filter(student -> student.getGrade() >= threshold)
                    .collect(Collectors.toList());
        }
    }

    // Задача 11 WIP

    static class Product {

    }

    static class Store {

    }

    // Задача 12 WIP

    interface PaymentSystem {

    }

    class CreditCard implements PaymentSystem {

    }

    class PayPal implements PaymentSystem {

    }

    // Задача 13 WIP

    class UniqueID {

    }

    // Задача 14 WIP

    class Point {

    }

    class Rectangle2 {

    }

    // Задача 15 WIP

    class ComplexNumber {

    }

    // Задача 16 WIP

    class Maxtrix {

    }

    // Задача 17 WIP

    class Player {

    }

    class Enemy {

    }

    class Weapon {

    }

    // Задача 18 WIP

    class Product2 {

    }

    class Order2 {

    }

    class Customer2 {

    }

    // Задача 19 WIP

    class Device {

    }

    class Smartphone extends Device {

    }

    class Laptop extends  Device {

    }

    // Задача 20 WIP

    class Player2 {

    }

    class Game2 {

    }
}

