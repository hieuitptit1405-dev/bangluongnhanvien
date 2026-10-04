import java.text.DecimalFormat;

public class Employee {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double salary() {
        return baseSalary;
    }

    public static class FullTimeEmployee extends Employee {
        private double allowance;

        public FullTimeEmployee(String id, String name, double baseSalary, double allowance) {
            super(id, name, baseSalary);
            this.allowance = allowance;
        }

        public double getAllowance() {
            return allowance;
        }

        @Override
        public double salary() {
            return baseSalary + allowance;
        }
    }

    public static class Intern extends Employee {
        private String school;

        public Intern(String id, String name, double baseSalary, String school) {
            super(id, name, baseSalary);
            this.school = school;
        }

        public String getSchool() {
            return school;
        }

        @Override
        public double salary() {
            return baseSalary * 0.7;
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
            new FullTimeEmployee("B25DCC067", "Nguyễn Xuân Hiếu", 10_000_000, 2_000_000),
            new Intern("B25DCC068", "Nguyễn Xuân Hiếu", 5_000_000, "Học viện Công nghệ Bưu chính Viễn thông"),
            new FullTimeEmployee("B25DCC069", "Nguyễn Xuân Hiếu", 12_000_000, 3_000_000),
            new Intern("B25DCC070", "Nguyễn Xuân Hiếu", 6_000_000, "Học viện Công nghệ Bưu chính Viễn thông")
        };

        DecimalFormat df = new DecimalFormat("#,###");
        double totalSalary = 0;

        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmployee) {
                FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
                System.out.println("Nhân viên " + fullTimeEmployee.getName() + ": "
                        + df.format(fullTimeEmployee.getBaseSalary()) + " + phụ cấp "
                        + df.format(fullTimeEmployee.getAllowance()) + " = "
                        + df.format(fullTimeEmployee.salary()) + " đ");
            } else if (employee instanceof Intern) {
                Intern intern = (Intern) employee;
                System.out.println("Thực tập sinh " + intern.getName() + ": "
                        + df.format(intern.getBaseSalary()) + " x 70% = "
                        + df.format(intern.salary()) + " đ");
            }

            totalSalary += employee.salary();
        }

        System.out.println("Tổng lương = " + df.format(totalSalary) + " đ");
    }
}
