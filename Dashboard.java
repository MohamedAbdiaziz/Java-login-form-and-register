import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class Dashboard implements ActionListener{

	JFrame frmDashboard = new JFrame();
	JLabel lblNewLabel_2 = new JLabel("Dashboard Here");
	JButton btnNewButton = new JButton("Add New User");
	
	
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	Dashboard(HashMap<String,String> loginInfoOrg2) {
		loginInfo = loginInfoOrg2;
		
		frmDashboard.getContentPane().setBackground(new Color(175, 238, 238));
		frmDashboard.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frmDashboard.setResizable(false);
		frmDashboard.setTitle("Dashboard");
		frmDashboard.setBounds(100, 100, 450, 300);
		frmDashboard.setSize(420, 420);
		frmDashboard.getContentPane().setLayout(null);
		
		
		lblNewLabel_2.setFont(new Font(null, Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(59, 26, 276, 45);
		frmDashboard.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("User");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(59, 113, 276, 45);
		frmDashboard.getContentPane().add(lblNewLabel_2_1);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmDashboard.dispose();
				AddNewUser nn = new AddNewUser(loginInfo);
				
				
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(59, 207, 276, 51);
		frmDashboard.getContentPane().add(btnNewButton);
		frmDashboard.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btnNewButton) {
			
		}
		
	}
}
