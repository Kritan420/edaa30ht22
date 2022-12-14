package src.textproc;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class BookReaderController {

    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {

        SortedListModel<Map.Entry<String, Integer>> sortedListM = new SortedListModel<Map.Entry<String, Integer>>(counter.getWordList());

        JList<Map.Entry<String, Integer>> myList = new JList<Map.Entry<String, Integer>>(sortedListM);

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        JScrollPane scrollPane = new JScrollPane(myList);
        JPanel jPanel = new JPanel();
        JButton alphB = new JButton("Alphabetic");
        JButton freqB = new JButton("Frequency");
        JButton searchB = new JButton("Find");
        JTextField jText = new JTextField(10);

        alphB.addActionListener(event -> sortedListM.sort((w1, w2) -> {
            myList.ensureIndexIsVisible(0);
            return w1.getKey().compareTo(w2.getKey());
        }));

        freqB.addActionListener(event -> sortedListM.sort((w1, w2) -> {
            myList.ensureIndexIsVisible(0);
            return w2.getValue().compareTo(w1.getValue());
        }));

        searchB.addActionListener(event -> {
            boolean found = false;
            for (int i = 0; i < myList.getModel().getSize(); i++) {
                if (myList.getModel().getElementAt(i).getKey().equals(jText.getText().toLowerCase().trim())) {
                    myList.ensureIndexIsVisible(i);
                    myList.setSelectedIndex(i);
                    found = true;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(frame, "Word not found", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        jText.addActionListener(searchB.getActionListeners()[0]);

        jPanel.add(alphB);
        jPanel.add(freqB);
        jPanel.add(jText);
        jPanel.add(searchB);

        pane.add(jPanel, BorderLayout.SOUTH);
        pane.add(scrollPane);

        frame.pack();
        frame.setVisible(true);
    }
}