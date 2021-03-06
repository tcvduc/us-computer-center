package HCMUS.Computer.Center.Client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import HCMUS.Computer.Center.Data.GiayChungNhanDB;

public class TraCuuGiayChungNhanScreen {
	JFrame f = new JFrame();
	
	// labels

	JLabel lbThongTinHocVienGiayChungNhan = new JLabel("Thông tin học viên - giấy chứng nhận");
	JLabel lbCapNhatTTGiayCN = new JLabel("Cập nhật thông tin giấy chứng nhận");
	JLabel lbMaHV = new JLabel("Mã học viên");
	JLabel lbMaHVForCheckbox = new JLabel("Mã học viên");
	
	JComboBox cbbMaHV ;
	JCheckBox chkbDaNhan = new JCheckBox("Đã nhận");
	
	// buttons
	JButton btnCapNhat = new JButton("Cập nhật");
	JButton btnBack = new JButton("Trở về");
	
	JTable tblHocVienGiayCN ;
	JScrollPane scrPanel ;
	
	JPanel topPanel = new JPanel(new GridLayout(1, 2));
	JPanel midPanel = new JPanel(new GridLayout(2, 1));
	JPanel botPanel = new JPanel(new GridLayout(1, 1));
	
	
	ActionListener btnBackActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			f.dispose();

		}
	};
	ActionListener btnCapNhatActionListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CapNhatHocVienGiayChungNhanScreen f2= new CapNhatHocVienGiayChungNhanScreen();
			String mahv= cbbMaHV.getSelectedItem().toString();
			f2.render(mahv);
			return;
		}
	};

	
	public void render() {
	
		f.setTitle("Tra cứu giấy chứng nhận");
		int x = 600;
		int y = 400;

		int pdTop = 20;
		int pdLeft = 80;
		int pdBot = 20;
		int pdRight = 80;
		
		// get data first
		GiayChungNhanDB cndb=new GiayChungNhanDB();
		cndb.getAll();

	

		// cbb mahocvien
		String dataMaHV[] = cndb.getMaHocVien();
		 cbbMaHV = new JComboBox(dataMaHV);


	

	
		
		btnBack.addActionListener(btnBackActionListener);
		btnCapNhat.addActionListener(btnCapNhatActionListener);
		

		// tbl giay chung nhan - hoc vien

		String dataHVGCN[][] = cndb.getData();
		String col[] = { "Mã học viên", "Tên học viên", "Mã lớp học", "Tên lớp học", "Trạng thái nhận" };
		 tblHocVienGiayCN = new JTable(dataHVGCN, col);
		 scrPanel = new JScrollPane(tblHocVienGiayCN);

		// panel

		
		topPanel.setBorder(BorderFactory.createEmptyBorder(pdTop, pdLeft, pdBot, pdRight));

		
		midPanel.setBorder(BorderFactory.createEmptyBorder(pdTop, pdLeft, pdBot, pdRight));

		
		botPanel.setBorder(BorderFactory.createEmptyBorder(pdTop, pdLeft, pdBot, pdRight));

		topPanel.add(lbMaHV);
		topPanel.add(cbbMaHV);
		topPanel.add(btnCapNhat);

//		midPanel.add(lbCapNhatTTGiayCN);
//		midPanel.add(lbMaHVForCheckbox);
//		midPanel.add(tfMaHV);
//		midPanel.add(chkbDaNhan);
//		midPanel.add(btnUpdate);
		midPanel.add(lbThongTinHocVienGiayChungNhan);
		midPanel.add(scrPanel);
		
//		botPanel.add(scrPanel);
		botPanel.add(btnBack);

		f.add(topPanel, BorderLayout.NORTH);
		f.add(midPanel, BorderLayout.CENTER);
		f.add(botPanel, BorderLayout.SOUTH);

		f.setSize(x, y);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}
}
