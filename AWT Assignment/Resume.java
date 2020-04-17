import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;


public class Resume extends Frame implements ActionListener,WindowListener,ItemListener {	
	Frame f;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
	Label title,l1,l2,l3,l4,l5,l6,l0,l7,l8,l9,l10,l11,l12,l13;
	Checkbox m,c,o;
	CheckboxGroup cbg;
	Choice l;
	Button b;
	
	Resume()
	{
		f = new Frame();
		
		
		Font myFont = new Font("SansSerif",Font.BOLD,15);
		
		title = new Label("RESUME");
		title.setBounds(200,30,100,15);
		title.setFont(myFont);
		 
		 
		
		l0 = new Label("Personal Details");
		l0.setBounds(10,50,200,12);
		l0.setFont(myFont);
		
		l1 = new Label("First name:");
		l1.setBounds(10, 80, 100, 20);
		
		t1 = new TextField(50);
		t1.setBounds(120, 80, 100, 20);
		
		l2 = new Label("Last name:");
		l2.setBounds(10,100,100, 20);
		
		t2 = new TextField(50);
		t2.setBounds(120, 100, 100, 20);
		
		l3 = new Label("Sex:");	
		l3.setBounds(10,120,40,20);
		
		cbg = new CheckboxGroup();
		m  = new Checkbox("M", cbg, false);
		m.setBounds(120,120,30,20);
		
		c = new Checkbox("F", cbg, false);
		c.setBounds(150,120,30,20);
		
		o = new Checkbox("Others", cbg, false);
		o.setBounds(180,120,60,20);
		
		l4 = new Label("DOB(dd/mm/yy):");
		l4.setBounds(10,140,100,20);
		
		t4 = new TextField(10);
		t4.setBounds(120,140,100,20);
                
                l12 = new Label("Mobile:");
                l12.setBounds(10,160,100,20);
                
                t12 = new TextField(10);
		t12.setBounds(120,160,100,20);
                
                l13 = new Label("Email:");
                l13.setBounds(10,180,100,20);
                
                t13 = new TextField(30);
		t13.setBounds(120,180,200,20);
                
                l11 = new Label("Address:");
                l11.setBounds(10,200,100,20);
                
                t11=new TextField(100);
                t11.setBounds(120,200,300,20);
	
		l5 = new Label("Education");
		l5.setBounds(10,240,100,20);
		l5.setFont(myFont);
		 
		l6 = new Label("Institute Name:");
		l6.setBounds(10,270,100,20);
		 
		t6 = new TextField(100);
		t6.setBounds(120,270,300,20);
		 
		l8 = new Label("Branch:");
		l8.setBounds(10,310,80,20);
		 
		t8 = new TextField(10);
		t8.setBounds(120,310,150,20);
		 
		l7 =  new Label("Semester:");
		l7.setBounds(10,290,80,20);
		 
		l9 = new Label("CGPA:");
		l9.setBounds(10,330,80,20);
		 
		t9 = new TextField(10);
		t9.setBounds(120,330,150,20);
		 
		l10 = new Label("Area of Interest:");
		l10.setBounds(10,350,100,20);
		 
		t10 = new TextField(10);
		t10.setBounds(120,350,150,20);
		 

		 
		l = new Choice();
		l.setBounds(120,290,150,25);
		 
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("4");
		l.add("5");
		l.add("6");
		l.add("7");
		l.add("8");
		l.add("completed");
		 
		b = new Button("Submit");
		b.setBounds(200,400,70,20);
		
		

		add(title);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(m);
		add(c);
		add(o);
		add(l4);
		add(t4);
                add(l12);
                add(t12);
                add(l13);
                add(t13);
                add(l11);
                add(t11);
		add(l5);
		add(l0);
		add(l6);
		add(t6);
		add(l7);
		add(l);
		add(l8);
		add(t8);
		add(l9);
		add(t9);
		add(l10);
		add(t10);
		add(b);
	
		setLayout(null);
		
		setSize(450,700);
		setVisible(true);
		addWindowListener(this);
		b.addActionListener(this);
		m.addItemListener(this);
	    c.addItemListener(this);
	    o.addItemListener(this);
	 
		
		
		
	}
	
	
	@Override public void windowClosing(WindowEvent evt) {
	      System.exit(0);
	   }
	
	
	
	String str = "";
	public void itemStateChanged(ItemEvent e)
	{
		 
	    if(m.getState() == true)
                str = "Male";
	    else if(c.getState() == true)
                str = "Female";
	    else if(o.getState() == true)
                str = "Other";
	}

	
	
	public void actionPerformed (ActionEvent ae)
	{
		
		
        String fname=t1.getText();
        String lname=t2.getText();
        String dob=t4.getText();
        String mob=t12.getText();
        String email=t13.getText();
        String addr=t11.getText();
        String instituteName=t6.getText();
        String branch=t8.getText();
        String sem=l.getSelectedItem();
        String cg = t9.getText();
        String interest = t10.getText();
         
        try{    
            FileWriter fw=new FileWriter("C:\\Users\\vikash kumar\\Desktop\\resume.txt");    
            fw.write("-----------------------RESUME-------------------------------\n\n\n"); 
            fw.write("\n\n Personal Details");
            fw.write("\n\n Name :- "+ fname + " " + lname); 
            fw.write("\n\n Sex :-  "+ str);
            fw.write("\n\n DOB :-  "+ dob);
            fw.write("\n\n Mobile :-  "+ mob);
            fw.write("\n\n Email ID :-  "+ email);
            fw.write("\n\n Address :- "+addr);
            fw.write("\n\n ----------------------------------------------------------------");
            fw.write("\n\n EDUCATION");
            fw.write("\n\n Institute name :- "+ instituteName);
            fw.write("\n\n Branch :- "+ branch);
            fw.write("\n\n Semester :- "+ sem);
            fw.write("\n\n CGPA :- "+ cg);
            fw.write("\n\n Interest :- "+ interest);
            fw.close();    
            }catch(Exception e){System.out.println(e);}    
            System.out.println("Success..."); 
      
		
	}
	
	public static void main (String args[]) {
            new Resume();	
	}
	@Override public void windowOpened(WindowEvent evt) { }
	@Override public void windowClosed(WindowEvent evt) { }
	@Override public void windowIconified(WindowEvent evt) { System.out.println("Window Iconified"); }
	@Override public void windowDeiconified(WindowEvent evt) { System.out.println("Window Deiconified"); }
	@Override public void windowActivated(WindowEvent evt) { System.out.println("Window Activated"); }
	@Override public void windowDeactivated(WindowEvent evt) { System.out.println("Window Deactivated"); }
	}