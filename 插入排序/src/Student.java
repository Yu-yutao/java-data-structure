public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student student) {
        return this.score - student.score;
    }

    @Override
    public boolean equals(Object student) {

        if (this == student)
            return true;

        if (this.getClass() != student.getClass())
            return false;

        Student another = (Student) student;
        return this.name.equals(another.name);
    }
}
