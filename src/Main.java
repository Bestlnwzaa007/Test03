import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        // สร้างหน้าต่างหลัก
        JFrame frame = new JFrame("ระบบเก็บเกรดนักเรียน");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ========== ส่วนบน: ช่องกรอกข้อมูล ==========
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JTextField nameField = new JTextField(10);
        JTextField scoreField = new JTextField(5);
        JButton addButton = new JButton("เพิ่มนักเรียน");

        inputPanel.add(new JLabel("ชื่อ:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("คะแนน:"));
        inputPanel.add(scoreField);
        inputPanel.add(addButton);

        // ========== ส่วนกลาง: ตารางแสดงผล ==========
        String[] columnNames = {"ชื่อ", "คะแนน", "เกรด"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // ========== เมื่อกดปุ่ม "เพิ่มนักเรียน" ==========
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String scoreText = scoreField.getText();

            if (name.isEmpty() || scoreText.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "กรุณากรอกชื่อและคะแนน",
                        "แจ้งเตือน",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int score = Integer.parseInt(scoreText);

                Student student = new Student(name, score);
                students.add(student);

                // เพิ่มแถวในตาราง
                tableModel.addRow(new Object[]{
                        student.getName(),
                        student.getScore(),
                        student.getGrade()
                });

                // เคลียร์ช่องกรอก
                nameField.setText("");
                scoreField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "กรุณาใส่คะแนนเป็นตัวเลข",
                        "ผิดพลาด",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // ใส่ทุกอย่างลงในหน้าต่าง
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}


