package ui.menu;

import model.Expense;
import model.ListOfExpense;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// applications menu to add expense
public class AddExpenseMenu extends Menu {
    // ==============================
    // FIELDS:

    // labels
    private JLabel nameLabel;
    private JLabel amountLabel;
    private JLabel dayLabel;
    private JLabel monthLabel;
    private JLabel yearLabel;

    // buttons
    private JButton enter;

    // text fields
    private JTextField nameInput;
    private JTextField amountInput;
    private JTextField dayInput;
    private JTextField monthInput;
    private JTextField yearInput;

    // ==============================
    // CONSTRUCTOR:

    // EFFECTS: creates a add expense menu
    public AddExpenseMenu(ListOfExpense listOfExpense) {
        super(listOfExpense);

        frame.setTitle("Budget Tracker: Add Expense");
        frame.setSize(530, 245);

        initializeLabels();
        initializeTextAndButtons();
        initializeListeners();

        addToPanel();
        panel.revalidate();
        panel.repaint();
    }

    // ==============================
    // METHODS:

    // MODIFIES: this
    // EFFECTS: initializes and adds text to all the present labels in this menu
    @Override
    public void initializeLabels() {
        nameLabel = new JLabel("Name: ");
        amountLabel = new JLabel("Amount:");
        dayLabel = new JLabel("Day of Purchase: ");
        monthLabel = new JLabel("Month of Purchase: ");
        yearLabel = new JLabel("Year of Purchase: ");
    }

    // MODIFIES: this
    // EFFECTS: initializes all action listeners
    @Override
    public void initializeListeners() {
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expense expense1 = new Expense(
                        Double.parseDouble(amountInput.getText()),
                        nameInput.getText(),
                        Integer.parseInt(dayInput.getText()),
                        Integer.parseInt(monthInput.getText()),
                        Integer.parseInt(yearInput.getText())
                );
                expense1.logCreateEvent();

                listOfExpense.addExpense(expense1);
                listOfExpense.logAddExpenseEvent();
            }
        });
    }

    public void invalidEntry() {
        JFrame invalidEntry = new JFrame();
        invalidEntry.add(new JLabel("Invalid Entry"));
    }

    // MODIFIES: this
    // EFFECTS: initializes all buttons used in menu
    private void initializeTextAndButtons() {
        // text fields
        nameInput = new JTextField(10);
        amountInput = new JTextField(10);
        dayInput = new JTextField(10);
        monthInput = new JTextField(10);
        yearInput = new JTextField(10);

        // buttons
        enter = new JButton("Enter");
    }

    // MODIFIES: Menu (super)
    // EFFECTS: adds all necessary elements to the panel
    @Override
    public void addToPanel() {
        addLabelandTextField(nameLabel,nameInput,0, panel);
        addLabelandTextField(amountLabel,amountInput,1, panel);
        addLabelandTextField(dayLabel,dayInput,2, panel);
        addLabelandTextField(monthLabel,monthInput,3, panel);
        addLabelandTextField(yearLabel,yearInput,4, panel);
        addButton(enter,5,panel);
    }

}
