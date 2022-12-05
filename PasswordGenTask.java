

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class PasswordGenTask extends JFrame
implements ActionListener{

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel vno;
	private JTextField tvno;
	private JLabel plen;
	private JTextField tplen;
	private JButton sub;
	private JButton reset;
	private JLabel res;



	public PasswordGenTask()
	{
		setTitle("Password Generator");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Password Generator");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);

		name = new JLabel("Name");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(100, 100);
		c.add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(190, 20);
		tname.setLocation(200, 100);
		c.add(tname);

		mno = new JLabel("Mobile");
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		mno.setSize(100, 20);
		mno.setLocation(100, 150);
		c.add(mno);

		tmno = new JTextField();
		tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		tmno.setSize(150, 20);
		tmno.setLocation(200, 150);
		c.add(tmno);

		vno = new JLabel("VehicleNo");
		vno.setFont(new Font("Arial", Font.PLAIN, 20));
		vno.setSize(100, 20);
		vno.setLocation(100, 200);
		c.add(vno);

		tvno = new JTextField();
		tvno.setFont(new Font("Arial", Font.PLAIN, 15));
		tvno.setSize(150, 20);
		tvno.setLocation(200, 200);
		c.add(tvno);

		plen = new JLabel("Pass Len");
		plen.setFont(new Font("Arial", Font.PLAIN, 20));
		plen.setSize(100, 20);
		plen.setLocation(100, 250);
		c.add(plen);

		tplen = new JTextField();
		tplen.setFont(new Font("Arial", Font.PLAIN, 15));
		tplen.setSize(150, 20);
		tplen.setLocation(200, 250);
		c.add(tplen);


		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(100, 20);
		sub.setLocation(150, 300);
		sub.addActionListener(this);
		c.add(sub);



		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(100, 350);
		c.add(res);


		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) {

			int i,length;    
			String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String lower="abcdefghijklmnopqrstuvvwxyz";
			String num="0123456789";
			String specialChars = " <>,.?/}]{[+_-)(*&^%$#@!+";
			String combination=tname.getText()+tmno.getText()+tvno.getText()+upper+lower+num+specialChars;
			length=Integer.parseInt(tplen.getText());
			char[] password=new char[length];
			Random r=new Random();
			for(i=0;i<length;i++)
			{
				password[i]=combination.charAt(r.nextInt(combination.length()));
			}



			res.setText("Generated Password:"+new String(password));


		}


	}


	public static void main(String[] args) throws Exception
	{
		new PasswordGenTask();
	}
}