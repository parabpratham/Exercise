package FramesInsert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Gui_db_main extends JFrame {

	/**
	 * @param args
	 */
	JLabel lblName;
	JLabel lbllocat;
	JLabel lblmanager;
	JLabel lbldeptid;
	JTextField txtDeptid;
	JTextField txtName;
	JTextField txtLocat;
	JTextField txtManager;
	JButton btInsert;
	JButton btUpdate;
	JButton btFind;
	JButton btDelete;

	public Gui_db_main()
	{
		JFrame frm=new JFrame("Searching");
		lblName=new JLabel("Department Name");
		lbllocat=new JLabel("Department Location");
		lblmanager=new JLabel("Manager");
		txtName=new JTextField(20);
		lbldeptid=new JLabel("Department ID");
		txtDeptid=new JTextField(20);
		txtLocat=new JTextField(20);
		txtManager=new JTextField(25);
		btInsert =new JButton("Insert");
		btUpdate =new JButton("Update");
		btDelete =new JButton("Delete");
		btFind =new JButton("Find");
		JPanel pan=new JPanel();
		pan.add(lbldeptid);
		pan.add(txtDeptid);
		pan.add(lblName);
		pan.add(txtName);
		pan.add(lbllocat);
		pan.add(txtLocat);
		pan.add(lblmanager);
		pan.add(txtManager);
		pan.add(btInsert);
		pan.add(btUpdate);
		pan.add(btDelete);
		pan.add(btFind);
	
		getContentPane().add(pan);
		setBounds(100,100,400,300);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setVisible(true);
	
		btInsert.addActionListener(new Myclass());
		btDelete.addActionListener(new Myclass());
		btUpdate.addActionListener(new Myclass());
		btFind.addActionListener(new Myclass());
	}
	
	class Myclass implements ActionListener{ 
		public void actionPerformed(ActionEvent e){
				try{
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:oci:@//localhost/XE","hr","hr");
					Statement st=con.createStatement();
					if( e.getSource() == btInsert){
						ResultSet rs = st.executeQuery("insert into departments2(department_id,department_name,manager_id,location_id,employee_count) values ("+Integer.parseInt(txtDeptid.getText())+",'"+txtName.getText()+"',"+Integer.parseInt(txtManager.getText())+","+Integer.parseInt(txtLocat.getText())+",0)");
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null,"Record inseted");
						}
						rs.close();
					}
					else if(e.getSource()== btDelete){
						//oshedar@gmail.com
						ResultSet rs = st.executeQuery("delete from departments1 where department_id ="+txtDeptid.getText());
						rs.close();
					}
					else if(e.getSource()== btUpdate){
						ResultSet rs = st.executeQuery("update departments1 set department_name = '"+txtName.getText() +"',manager_id ="+txtManager.getText()+",location_id= "+txtLocat.getText()+"where department_id ="+txtDeptid.getText());
						rs.close();
					}
					else if(e.getSource()== btFind){
						ResultSet rs = st.executeQuery("select* from departments1 where department_id ="+txtDeptid.getText());
						while(rs.next()){
							txtName.setText(rs.getString(2));
							txtManager.setText(rs.getString(3));
							txtLocat.setText(rs.getString(4));
						}
						rs.close();
					}
				}catch(ClassNotFoundException nex){
					nex.printStackTrace();
				}catch (SQLException sqe){
					sqe.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		new Gui_db_main();
		
	}

}

