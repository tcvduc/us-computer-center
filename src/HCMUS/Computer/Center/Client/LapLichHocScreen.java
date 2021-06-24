package HCMUS.Computer.Center.Client;
import javax.swing.*;

import HCMUS.Computer.Center.Data.KhoaHocDB;
import HCMUS.Computer.Center.Logic.LichHocController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LapLichHocScreen {
	public void render() {
		JFrame fm=new JFrame();
		fm.setTitle("Lập lịch học");
		int fmxSize=600;
		int fmySize=500;
		
		// labels
		JLabel lbMaKhoaHoc=new JLabel("Mã khóa học");
		JLabel lbNgayBatDau=new JLabel("Ngày bắt đầu");
		JLabel lbNgayKT=new JLabel("Ngày kết thúc");
		JLabel lbNgayHocTrongTuan=new JLabel("Ngày học trong tuần");
		JLabel lbGioBatDau=new JLabel("Giờ bắt đầu");
		JLabel lbGioKT=new JLabel("Giờ kết thúc");
		
		// textfield
		JTextField tfNgayBD=new JTextField();
		JTextField tfNgayKT=new JTextField();
		JTextField tfNgayHocTrongTuan=new JTextField();
		JTextField tfGioBD=new JTextField();
		JTextField tfGioKT=new JTextField();
		
		// makh combobox
		KhoaHocDB khdb=new KhoaHocDB();
		String dataMaKH[]= khdb.getMaKhoaHoc();
		JComboBox cbbMaKH=new JComboBox(dataMaKH);
		
		
		// buttons
		JButton btnLapLich=new JButton("Lập lịch");
		JButton btnBack=new JButton("Trở về");
		
		
		ActionListener btnBackListener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fm.dispose();
				
			}
		};
		
		ActionListener btnLapLichActionListener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ngayBatDau=tfNgayBD.getText();
				String ngayKetThuc=tfNgayKT.getText();
				String ngayHocTrongTuan=tfNgayHocTrongTuan.getText();
				String gioBatDau=tfGioBD.getText();
				String gioKetThuc=tfGioKT.getText();
				String maKhoaHoc=cbbMaKH.getSelectedItem().toString();
				
				LichHocController lichhocController=new LichHocController();
				lichhocController.lapLichHoc(ngayBatDau, ngayKetThuc, ngayHocTrongTuan, gioBatDau, gioKetThuc, maKhoaHoc);
		
				JOptionPane.showMessageDialog(new JFrame(), "Thêm thành công!");
				
			}
		};
		
		btnBack.addActionListener(btnBackListener);
		btnLapLich.addActionListener(btnLapLichActionListener);
		

		
		// panel
		Panel pn=new Panel();
		JButton posNORTH=new JButton("NORTH");
		JButton posCENTER=new JButton("CENTER");
		JButton posSOUTH=new JButton("SOUTH");

		JLabel posNORTH2=new JLabel("NORTH");
		JLabel posCENTER2=new JLabel("CENTER");
		JLabel posSOUTH2=new JLabel("SOUTH");
		
		JPanel posNORTH3=new JPanel();
		posNORTH3.setBorder(BorderFactory.createEmptyBorder(5,80,5,80));
		GridLayout pos3Grid=new GridLayout(2,1);
		posNORTH3.setLayout(pos3Grid);
		
		JPanel posCENTER3=new JPanel(new GridLayout(10,1));
		posCENTER3.setBorder(BorderFactory.createEmptyBorder(5,80,5,80));
		JPanel posSOUTH3=new JPanel(new GridLayout(1,1));
		posSOUTH3.setBorder(BorderFactory.createEmptyBorder(5,80,80,80));
		
		
	
		
		posNORTH3.add(lbMaKhoaHoc);
		posNORTH3.add(cbbMaKH);
		
		posCENTER3.add(lbNgayBatDau);
		posCENTER3.add(tfNgayBD);
		posCENTER3.add(lbNgayHocTrongTuan);
		posCENTER3.add(tfNgayHocTrongTuan);
		posCENTER3.add(lbNgayKT);
		posCENTER3.add(tfNgayKT);
		posCENTER3.add(lbGioBatDau);
		posCENTER3.add(tfGioBD);
		posCENTER3.add(lbGioKT);
		posCENTER3.add(tfGioKT);
		
		posSOUTH3.add(btnLapLich);
		posSOUTH3.add(btnBack);
		
		
		

		
		
		
		
		
//		fm.add(pn);
		
		fm.add(posNORTH3,BorderLayout.NORTH);
		fm.add(posCENTER3,BorderLayout.CENTER);
		fm.add(posSOUTH3,BorderLayout.SOUTH);
	
		
		
		fm.setSize(fmxSize,fmySize);
		fm.setLocationRelativeTo(null);
		fm.setVisible(true);
		
	}
}
