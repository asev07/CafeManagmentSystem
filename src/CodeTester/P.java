package CodeTester;

import EMPLOYEE.Employee;
import EMPLOYEE.GetEmployeeInfo;
import Order.*;
import ROLE.GetRole;
import SERVICE.GetServices;
import SERVICE.Service;
import SERVICE.ServiceNames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class P extends JFrame implements ActionListener,MouseListener{
    double fp = 0, drp = 0, cp = 0, dep = 0;
    static int id,tOrders;
    JLayeredPane layer=new JLayeredPane();

    JPanel sidepanel=new JPanel();
    JPanel s2background=new JPanel();

    JLabel logop=new JLabel();
    JLabel profiletitle=new JLabel();
    JLabel userfirstnamelable=new JLabel();
    JLabel firstnamelable=new JLabel();
    JLabel userlastnamelable=new JLabel();
    JLabel lastnamelable=new JLabel();
    JLabel useragelable=new JLabel();
    JLabel agelable=new JLabel();
    JLabel userroleidlable=new JLabel();
    JLabel roleidlable=new JLabel();
    JLabel usersalarylable=new JLabel();
    JLabel salarylable=new JLabel();
    JLabel usercontratlable=new JLabel();
    JLabel contratlable=new JLabel();
    JLabel eaddedit=new JLabel();
    JLabel employees=new JLabel();
    JLabel found=new JLabel();
    JLabel efirstname=new JLabel();
    JLabel elastname=new JLabel();
    JLabel egender=new JLabel();
    JLabel erole=new JLabel();
    JLabel edateofbirth=new JLabel();
    JLabel esmallname=new JLabel();
    JLabel esmallgender=new JLabel();
    JLabel esmallage=new JLabel();
    JLabel esmallrole=new JLabel();

    JLabel orderrecordtitle=new JLabel();
    JLabel usertotalrevenue=new JLabel();
    JLabel totalrevenue=new JLabel();
    JLabel usertotalorder=new JLabel();
    JLabel totalorder=new JLabel();
    JLabel usertoporder=new JLabel();
    JLabel toporder=new JLabel();
    JLabel orderreport=new JLabel();
    JLabel item=new JLabel();
    JLabel orderid=new JLabel();
    JLabel price=new JLabel();
    JLabel employeename=new JLabel();

    JLabel addordertitle=new JLabel();
    JLabel usercustomername=new JLabel();
    JLabel addstotalevenue=new JLabel();
    JLabel useraddstotalrevenue=new JLabel();
    JLabel addstotalorder=new JLabel();
    JLabel useraddstotalorder=new JLabel();
    JLabel date=new JLabel();
    JLabel foodlabel=new JLabel();
    JLabel coffelabel=new JLabel();
    JLabel drinklabel=new JLabel();
    JLabel disertlabel=new JLabel();
    JLabel order=new JLabel();
    JLabel useraddsorder=new JLabel();
    JLabel addsitem=new JLabel();
    JLabel addsprice=new JLabel();
    JLabel quantity=new JLabel();
    JLabel choice1=new JLabel();
    JLabel choice2=new JLabel();
    JLabel choice3=new JLabel();
    JLabel choice4=new JLabel();
    JLabel price1=new JLabel();
    JLabel price2=new JLabel();
    JLabel price3=new JLabel();
    JLabel price4=new JLabel();
    JLabel itemprice1=new JLabel();
    JLabel itemprice2=new JLabel();
    JLabel itemprice3=new JLabel();
    JLabel itemprice4=new JLabel();
    JLabel addstotal=new JLabel();
    JLabel useraddstotal=new JLabel();
    JLabel recored=new JLabel();

    JLabel employeetitle=new JLabel();

    JLabel salaryimagelabel=new JLabel();
    JLabel contratimagelabel=new JLabel();
    JLabel infoimagelabel=new JLabel();



    JLabel orderPrice = new JLabel();
    JLabel orderDescription = new JLabel();


    JLabel totrevimagelabel=new JLabel();
    JLabel totordimagelabel=new JLabel();
    JLabel topordimagelabel=new JLabel();

    JButton personbutton=new JButton();
    JButton orderbutton=new JButton();
    JButton addbutton=new JButton();
    JButton exitbutton=new JButton();
    JButton addorderrecrdbuButton=new JButton();
    JButton employeebutton=new JButton();
    JButton removebutton1=new JButton();
    JButton removebutton2=new JButton();
    JButton removebutton3=new JButton();
    JButton removebutton4=new JButton();






    R topspliterpanel=new R();
    R personclickedbackground=new R();
    R personclickedbuttonbackground=new R();
    R orderclickedbackground=new R();
    R orderclickedbuttonbackground=new R();
    R addclickedbackground=new R();
    R addclickedbuttonbackground=new R();
    R employeeclickedbackground=new R();
    R employeeclickedbuttonbackground=new R();
    R exitclickedbackground=new R();
    R personinfopanel=new R();

    JButton addemployebutton=new JButton();
    JButton listemployeebutton=new JButton();
    JButton aeaddemployebutton=new JButton();
    JButton aeeditemployeebutton=new JButton();
    JButton searchbutton=new JButton();

    R personsalarypanel=new R();
    R personcontratpanel=new R();
    R orderrecordtotalpanel=new R();
    R orderrecordtotaliteampanel=new R();
    R orderrecorddatapanel=new R();
    R orderrecordpopularpanel=new R();
    R orderrecordspliter=new R();

    R addssplit=new R();
    R addstotalrevenuepanel=new R();
    R addstotalorderpanel=new R();
    R addsrightorderpanel=new R();
    R addtheorderrecord=new R();

    R employeeleftpanel=new R();
    R employeerightpanel=new R();

    String column[]= {"Order Id","Order name","catagory","quantity","employee","price"};
//getting orders data fro the data base
    GetOrder o = new GetOrder();
    Order ord[][] = o.GetOrders();
    //converts the order data in to a table format
    String data[][]= getOrderData(ord);


//gets service names from the database for the add order page
    GetServices services = new GetServices();
    ServiceNames sNames = services.getServices();


 GetEmployeeInfo getEmp = new GetEmployeeInfo();

 Employee[][] emp = getEmp.GetEmployees();
    String column2[]= {"Id","FirstName","LastName","Position","Salary","Date OF Employment"};
    String data2[][]= getEmployeeData(emp);




    String fooddata[]= getserviceData(sNames.food);
    String coffedata[]= getserviceData(sNames.coffee);
    String drinkdata[]= getserviceData(sNames.drinks);
    String disertdata[]= getserviceData(sNames.desert);

    GetRole g = new GetRole();
    String roles[]= g.GetPosition();
    String dates[]= {
            "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"
    };
    String monthes[]= {
            "01","02","03","04","05","06","07","08","09","10","11","12"
    };
    String years[]= new String[123];


    JTable orderrecordtable=new JTable(data,column);
    JTable employeetable=new JTable(data2,column2);

    JScrollPane orderrecordscrollpanel=new JScrollPane(orderrecordtable);
    JScrollPane employeescrollpanel=new JScrollPane(employeetable);

    JComboBox food=new JComboBox(fooddata);
    JComboBox coffe=new JComboBox(coffedata);
    JComboBox drinks=new JComboBox(drinkdata);
    JComboBox disert=new JComboBox(disertdata);

    JTextField quantity1=new JTextField();
    JTextField quantity2=new JTextField();
    JTextField quantity3=new JTextField();
    JTextField quantity4=new JTextField();

    JTextField firstname=new JTextField();
    JTextField lastname=new JTextField();
    JTextField search=new JTextField();

    JRadioButton male= new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup group=new ButtonGroup();

    JComboBox day=new JComboBox(dates);
    JComboBox month=new JComboBox(monthes);
    JComboBox year;
    JComboBox role=new JComboBox(roles);

    ImageIcon logo=new ImageIcon("logo.png");
    ImageIcon person=new ImageIcon("person.png");
    ImageIcon personc=new ImageIcon("personc.png");
    ImageIcon orderr=new ImageIcon("orderr.png");
    ImageIcon orderrc=new ImageIcon("orderrc.png");
    ImageIcon addo=new ImageIcon("addo.png");
    ImageIcon addoc=new ImageIcon("addoc.png");
    ImageIcon exit=new ImageIcon("exit.png");
    ImageIcon employeescr = new ImageIcon("employee.png");
    ImageIcon employeescrc = new ImageIcon("employeec.png");

    ImageIcon scrlog=new ImageIcon("screen_logo.png");
    ImageIcon infopanelimg=new ImageIcon("infoimage.png");
    ImageIcon salarypanelimg=new ImageIcon("salaryimage.png");
    ImageIcon contratpanelimg=new ImageIcon("contratimage.png");
    ImageIcon removeimg=new ImageIcon("removeimage.png");
    ImageIcon removeimgh=new ImageIcon("removeimageh.png");
    ImageIcon adde = new ImageIcon("adde.png");
    ImageIcon addec = new ImageIcon("addec.png");
    ImageIcon liste = new ImageIcon("liste.png");
    ImageIcon listec = new ImageIcon("listec.png");
    ImageIcon serc=new ImageIcon("Search.png");

    ImageIcon totalrevenueimg=new ImageIcon("total.png");
    ImageIcon totalordersimg=new ImageIcon("totalorder.png");
    ImageIcon toporderimg=new ImageIcon("toporder.png");

    Color darkblue =new Color(31,29,43);
    Color lightred=new Color(234,124,105);
    Color lightdarkblue=new Color(37,40,54);
    Color lightgray=new Color(163,178,186);


    public P(int loggedId) throws SQLException {

        Employee e;

        e = new Employee();
        GetEmployeeInfo getInfo = new GetEmployeeInfo();
        e = getInfo.getEmployeeInfo(loggedId);
        id = loggedId;
System.out.println(id + "is the id from the constructor");

        // TODO Auto-generated constructor stub
        personbutton.setIcon(personc);
        personbutton.setContentAreaFilled(false);
        personbutton.setFocusable(false);
        personbutton.setBorderPainted(false);
        personbutton.setBounds(21,116,54,54);
        personbutton.addActionListener(this);
        personbutton.addMouseListener(this);

        personclickedbackground.setBackground(lightred);
        personclickedbackground.setRoundTopLeft(11);
        personclickedbackground.setRoundTopRight(11);
        personclickedbackground.setRoundBottomLeft(11);
        personclickedbackground.setRoundBottomRight(11);
        personclickedbackground.setBounds(21,116,54,54);

        personclickedbuttonbackground.setBounds(11,105,89,75);
        personclickedbuttonbackground.setBackground(lightdarkblue);
        personclickedbuttonbackground.setRoundTopLeft(18);
        personclickedbuttonbackground.setRoundTopRight(18);
        personclickedbuttonbackground.setRoundBottomLeft(18);
        personclickedbuttonbackground.setRoundBottomRight(18);

        orderbutton.setIcon(orderr);
        orderbutton.setContentAreaFilled(false);
        orderbutton.setFocusable(false);
        orderbutton.setBorderPainted(false);
        orderbutton.setBounds(21,216,54,54);
        orderbutton.addActionListener(this);
        orderbutton.addMouseListener(this);

        orderclickedbackground.setBackground(lightred);
        orderclickedbackground.setRoundTopLeft(11);
        orderclickedbackground.setRoundTopRight(11);
        orderclickedbackground.setRoundBottomLeft(11);
        orderclickedbackground.setRoundBottomRight(11);
        orderclickedbackground.setBounds(21,216,54,54);
        orderclickedbackground.setVisible(false);

        orderclickedbuttonbackground.setBounds(11,206,89,75);
        orderclickedbuttonbackground.setBackground(lightdarkblue);
        orderclickedbuttonbackground.setRoundTopLeft(18);
        orderclickedbuttonbackground.setRoundTopRight(18);
        orderclickedbuttonbackground.setRoundBottomLeft(18);
        orderclickedbuttonbackground.setRoundBottomRight(18);
        orderclickedbuttonbackground.setVisible(false);

        addbutton.setIcon(addo);
        addbutton.setContentAreaFilled(false);
        addbutton.setFocusable(false);
        addbutton.setBorderPainted(false);
        addbutton.setBounds(21,322,54,54);
        addbutton.addActionListener(this);
        addbutton.addMouseListener(this);

        employeebutton.setIcon(employeescr);
        employeebutton.setContentAreaFilled(false);
        employeebutton.setFocusable(false);
        employeebutton.setBorderPainted(false);
        employeebutton.setBounds(21,418,54,54);
        employeebutton.addActionListener(this);
        employeebutton.addMouseListener(this);

        exitbutton.setIcon(exit);
        exitbutton.setContentAreaFilled(false);
        exitbutton.setFocusable(false);
        exitbutton.setBorderPainted(false);
        exitbutton.setBounds(21,720,54,54);
        exitbutton.addActionListener(this);
        exitbutton.addMouseListener(this);

        addemployebutton.setIcon(addec);
        addemployebutton.setText("Add/Edit Employee");
        addemployebutton.setForeground(lightred);
        addemployebutton.setIconTextGap(10);
        addemployebutton.setFont(new Font(null,Font.PLAIN,17));
        addemployebutton.setBackground(new Color(84,54,59));
        addemployebutton.setBounds(138,113,265,84);
        addemployebutton.setFocusable(false);
        addemployebutton.setBorderPainted(false);
        addemployebutton.addMouseListener(this);
        addemployebutton.addActionListener(this);
        addemployebutton.setVisible(false);

        listemployeebutton.setIcon(liste);
        listemployeebutton.setText("Display All Employee");
        listemployeebutton.setForeground(Color.white);
        listemployeebutton.setIconTextGap(10);
        listemployeebutton.setFont(new Font(null,Font.PLAIN,17));
        listemployeebutton.setBackground(new Color(84,54,59));
        listemployeebutton.setBounds(138,197,265,84);
        listemployeebutton.setFocusable(false);
        listemployeebutton.setBorderPainted(false);
        listemployeebutton.setContentAreaFilled(false);
        listemployeebutton.addMouseListener(this);
        listemployeebutton.addActionListener(this);
        listemployeebutton.setVisible(false);

        removebutton1.setIcon(removeimg);
        removebutton1.setContentAreaFilled(false);
        removebutton1.setFocusable(false);
        removebutton1.setBorderPainted(false);
        removebutton1.setBounds(1022,262,46,47);
        removebutton1.addActionListener(this);
        removebutton1.addMouseListener(this);
        removebutton1.setVisible(false);

        removebutton2.setIcon(removeimg);
        removebutton2.setContentAreaFilled(false);
        removebutton2.setFocusable(false);
        removebutton2.setBorderPainted(false);
        removebutton2.setBounds(1022,380,46,47);
        removebutton2.addActionListener(this);
        removebutton2.addMouseListener(this);
        removebutton2.setVisible(false);

        removebutton3.setIcon(removeimg);
        removebutton3.setContentAreaFilled(false);
        removebutton3.setFocusable(false);
        removebutton3.setBorderPainted(false);
        removebutton3.setBounds(1022,497,46,47);
        removebutton3.addActionListener(this);
        removebutton3.addMouseListener(this);
        removebutton3.setVisible(false);

        removebutton4.setIcon(removeimg);
        removebutton4.setContentAreaFilled(false);
        removebutton4.setFocusable(false);
        removebutton4.setBorderPainted(false);
        removebutton4.setBounds(1022,615,46,47);
        removebutton4.addActionListener(this);
        removebutton4.addMouseListener(this);
        removebutton4.setVisible(false);

        choice1.setFont(new Font(null,0,13));
        choice1.setForeground(Color.white);
        choice1.setBounds(789,214,350,13);
        choice1.setVisible(false);

        choice2.setFont(new Font(null,0,13));
        choice2.setForeground(Color.white);
        choice2.setBounds(789,333,350,13);
        choice2.setVisible(false);

        choice3.setFont(new Font(null,0,13));
        choice3.setForeground(Color.white);
        choice3.setBounds(789,450,350,13);
        choice3.setVisible(false);

        choice4.setFont(new Font(null,0,13));
        choice4.setForeground(Color.white);
        choice4.setBounds(789,568,350,13);
        choice4.setVisible(false);

        quantity1.setBackground(new Color(45,48,62));
        quantity1.setForeground(Color.white);
        quantity1.setBounds(961,207,45,45);
        quantity1.setCaretColor(Color.white);
        quantity1.setText("1");
        quantity1.setHorizontalAlignment(JTextField.CENTER);
        quantity1.addActionListener(this);
        quantity1.setVisible(false);

        quantity2.setBackground(new Color(45,48,62));
        quantity2.setForeground(Color.white);
        quantity2.setBounds(961,325,45,45);
        quantity2.setCaretColor(Color.white);
        quantity2.setText("1");
        quantity2.setHorizontalAlignment(JTextField.CENTER);
        quantity2.addActionListener(this);
        quantity2.setVisible(false);

        quantity3.setBackground(new Color(45,48,62));
        quantity3.setForeground(Color.white);
        quantity3.setBounds(961,442,45,45);
        quantity3.setCaretColor(Color.white);
        quantity3.setText("1");
        quantity3.setHorizontalAlignment(JTextField.CENTER);
        quantity3.addActionListener(this);
        quantity3.setVisible(false);

        quantity4.setBackground(new Color(45,48,62));
        quantity4.setForeground(Color.white);
        quantity4.setText("1");
        quantity4.setBounds(961,560,45,45);
        quantity4.setCaretColor(Color.white);
        quantity4.setHorizontalAlignment(JTextField.CENTER);
        quantity4.addActionListener(this);
        quantity4.setVisible(false);

        eaddedit.setText("Add/Edit Employe");
        eaddedit.setForeground(Color.white);
        eaddedit.setFont(new Font(null,Font.PLAIN,20));
        eaddedit.setBounds(459,135,250,20);
        eaddedit.setVisible(false);

        employees.setText("Employee's");
        employees.setForeground(Color.white);
        employees.setFont(new Font(null,Font.PLAIN,20));
        employees.setBounds(459,135,250,20);
        employees.setVisible(false);

        found.setForeground(Color.green);
        found.setFont(new Font(null,Font.PLAIN,20));
        found.setBounds(927,221,150,20);
        found.setVisible(false);


        search.setText("Enter Id");
        search.setBackground(new Color(45,48,62));
        search.setForeground(new Color(200,205,209));
        search.setBorder(BorderFactory.createDashedBorder(new Color(54,57,70) , 1, 0));
        search.setCaretColor(Color.darkGray);
        search.setFont(new Font(null,0,28));
        search.setBounds(459,170,382,70);
        search.setVisible(false);

        searchbutton.setIcon(serc);
        searchbutton.setBounds(842,170,54,70);
        searchbutton.setBackground(Color.white);
        searchbutton.setFocusable(false);
        searchbutton.setBorder(BorderFactory.createDashedBorder(Color.white, 2, 0));
        searchbutton.addActionListener(this);
        searchbutton.setVisible(false);

        efirstname.setText("First Name");
        efirstname.setForeground(Color.white);
        efirstname.setFont(new Font(null,Font.PLAIN,20));
        efirstname.setBounds(459,271,250,20);
        efirstname.setVisible(false);

        firstname.setBackground(new Color(45,48,62));
        firstname.setForeground(new Color(200,205,209));
        firstname.setBorder(BorderFactory.createDashedBorder(new Color(54,57,70) , 1, 0));
        firstname.setCaretColor(Color.white);
        firstname.setFont(new Font(null,0,23));
        firstname.setBounds(459,301,345,42);
        firstname.setVisible(false);

        elastname.setText("Last Name");
        elastname.setForeground(Color.white);
        elastname.setFont(new Font(null,Font.PLAIN,20));
        elastname.setBounds(459,362,250,20);
        elastname.setVisible(false);


        lastname.setBackground(new Color(45,48,62));
        lastname.setForeground(new Color(200,205,209));
        lastname.setBorder(BorderFactory.createDashedBorder(new Color(54,57,70) , 1, 0));
        lastname.setCaretColor(Color.white);
        lastname.setFont(new Font(null,0,23));
        lastname.setBounds(459,397,345,42);
        lastname.setVisible(false);


        edateofbirth.setText("Date Of Employment");
        edateofbirth.setForeground(Color.white);
        edateofbirth.setFont(new Font(null,Font.PLAIN,20));
        edateofbirth.setBounds(459,466,250,20);
        edateofbirth.setVisible(false);

        day.setBounds(459,515,40,23);
        day.setVisible(false);

        month.setBounds(506,515,40,23);
        month.setVisible(false);

        for (int i=2000;i<2025;i++) {
            years[i-2000]=""+i;
        }
        year=new JComboBox(years);
        year.setBounds(553,515,60,23);
        year.setVisible(false);

        egender.setText("Gender");
        egender.setForeground(Color.white);
        egender.setFont(new Font(null,Font.PLAIN,20));
        egender.setBounds(674,466,250,20);
        egender.setVisible(false);

        group.add(male);
        group.add(female);

        male.setBounds(672,490,200,80);
        male.setContentAreaFilled(false);
        male.setFont(new Font(null,0,13));
        male.setForeground(Color.white);
        male.setFocusable(false);
        male.setVisible(false);

        female.setBounds(739,490,200,80);
        female.setContentAreaFilled(false);
        female.setFont(new Font(null,0,13));
        female.setForeground(Color.white);
        female.setFocusable(false);
        female.setVisible(false);

        erole.setText("Employee Roles");
        erole.setForeground(Color.white);
        erole.setFont(new Font(null,Font.PLAIN,20));
        erole.setBounds(459,575,250,20);
        erole.setVisible(false);

        role.setBounds(459,607,345,42);
        role.setFont(new Font(null,Font.BOLD,20));
        role.setVisible(false);
        role.setSelectedIndex(-1);


        esmallname.setText("Name");
        esmallname.setForeground(Color.white);
        esmallname.setFont(new Font(null,Font.PLAIN,13));
        esmallname.setBounds(432,202,250,13);
        esmallname.setVisible(false);

        esmallgender.setText("Gender");
        esmallgender.setForeground(Color.white);
        esmallgender.setFont(new Font(null,Font.PLAIN,13));
        esmallgender.setBounds(587,202,250,13);
        esmallgender.setVisible(false);

        esmallage.setText("Age");
        esmallage.setForeground(Color.white);
        esmallage.setFont(new Font(null,Font.PLAIN,13));
        esmallage.setBounds(745,202,250,13);
        esmallage.setVisible(false);

        esmallrole.setText("Role");
        esmallrole.setForeground(Color.white);
        esmallrole.setFont(new Font(null,Font.PLAIN,13));
        esmallrole.setBounds(900,202,250,13);
        esmallrole.setVisible(false);

        aeaddemployebutton.setBounds(459,679,165,47);
        aeaddemployebutton.setForeground(lightred);
        aeaddemployebutton.setFocusable(false);
        aeaddemployebutton.setText("Add Employee");
        aeaddemployebutton.setBorder(BorderFactory.createDashedBorder(lightred, 2, 0));
        aeaddemployebutton.setContentAreaFilled(false);
        aeaddemployebutton.setFont(new Font(null,Font.PLAIN,16));
        aeaddemployebutton.setVisible(false);

        aeeditemployeebutton.setBounds(631,679,165,47);
        aeeditemployeebutton.setForeground(lightred);
        aeeditemployeebutton.setFocusable(false);
        aeeditemployeebutton.setBorder(BorderFactory.createDashedBorder(lightred, 2, 0));
        aeeditemployeebutton.setText("Edit Employee");
        aeeditemployeebutton.setContentAreaFilled(false);
        aeeditemployeebutton.setFont(new Font(null,Font.PLAIN,16));
        aeeditemployeebutton.setVisible(false);

        itemprice1.setForeground(lightgray);
        itemprice1.setBounds(789,236,200,12);
        itemprice1.setFont(new Font(null,0,12));
        itemprice1.setVisible(false);

        itemprice2.setForeground(lightgray);
        itemprice2.setBounds(789,354,200,12);
        itemprice2.setFont(new Font(null,0,12));
        itemprice2.setVisible(false);

        itemprice3.setForeground(lightgray);
        itemprice3.setBounds(789,472,200,12);
        itemprice3.setFont(new Font(null,0,12));
        itemprice3.setVisible(false);

        itemprice4.setForeground(lightgray);
        itemprice4.setBounds(789,589,200,12);
        itemprice4.setFont(new Font(null,0,12));
        itemprice4.setVisible(false);

        price1.setForeground(Color.white);
        price1.setBounds(1033,226,200,13);
        price1.setFont(new Font(null,0,13));
        price1.setVisible(false);

        price2.setForeground(Color.white);
        price2.setBounds(1033,343,200,13);
        price2.setFont(new Font(null,0,13));
        price2.setVisible(false);

        price3.setForeground(Color.white);
        price3.setBounds(1033,461,200,13);
        price3.setFont(new Font(null,0,13));
        price3.setVisible(false);

        price4.setForeground(Color.white);
        price4.setBounds(1033,579,200,13);
        price4.setFont(new Font(null,0,13));
        price4.setVisible(false);

        addtheorderrecord.setBackground(lightred);
        addtheorderrecord.setBounds(792,732,250,45);
        addtheorderrecord.setRoundTopLeft(12);
        addtheorderrecord.setRoundTopRight(12);
        addtheorderrecord.setRoundBottomLeft(12);
        addtheorderrecord.setRoundBottomRight(12);
        addtheorderrecord.add(addorderrecrdbuButton);
        addtheorderrecord.setVisible(false);

        addorderrecrdbuButton.setText("Make The Order");
        addorderrecrdbuButton.setContentAreaFilled(false);
        addorderrecrdbuButton.setFocusable(false);
        addorderrecrdbuButton.setBorderPainted(false);
        addorderrecrdbuButton.setFont(new Font(null,Font.BOLD,13));
        addorderrecrdbuButton.setForeground(Color.white);
        addorderrecrdbuButton.addActionListener(this);
        addorderrecrdbuButton.addMouseListener(this);
        addorderrecrdbuButton.setVisible(false);

        addclickedbackground.setBackground(lightred);
        addclickedbackground.setRoundTopLeft(11);
        addclickedbackground.setRoundTopRight(11);
        addclickedbackground.setRoundBottomLeft(11);
        addclickedbackground.setRoundBottomRight(11);
        addclickedbackground.setBounds(21,322,54,54);
        addclickedbackground.setVisible(false);

        addclickedbuttonbackground.setBounds(11,311,89,75);
        addclickedbuttonbackground.setBackground(lightdarkblue);
        addclickedbuttonbackground.setRoundTopLeft(18);
        addclickedbuttonbackground.setRoundTopRight(18);
        addclickedbuttonbackground.setRoundBottomLeft(18);
        addclickedbuttonbackground.setRoundBottomRight(18);
        addclickedbuttonbackground.setVisible(false);

        employeeclickedbackground.setBackground(lightred);
        employeeclickedbackground.setRoundTopLeft(11);
        employeeclickedbackground.setRoundTopRight(11);
        employeeclickedbackground.setRoundBottomLeft(11);
        employeeclickedbackground.setRoundBottomRight(11);
        employeeclickedbackground.setBounds(21,418,54,54);
        employeeclickedbackground.setVisible(false);

        employeeclickedbuttonbackground.setBounds(11,407,89,75);
        employeeclickedbuttonbackground.setBackground(lightdarkblue);
        employeeclickedbuttonbackground.setRoundTopLeft(18);
        employeeclickedbuttonbackground.setRoundTopRight(18);
        employeeclickedbuttonbackground.setRoundBottomLeft(18);
        employeeclickedbuttonbackground.setRoundBottomRight(18);
        employeeclickedbuttonbackground.setVisible(false);

        exitclickedbackground.setBackground(new Color(37,40,54));
        exitclickedbackground.setRoundTopLeft(11);
        exitclickedbackground.setRoundTopRight(11);
        exitclickedbackground.setRoundBottomLeft(11);
        exitclickedbackground.setRoundBottomRight(11);
        exitclickedbackground.setBounds(21,720,54,54);
        exitclickedbackground.setVisible(false);

        profiletitle.setText("profile");
        profiletitle.setFont(new Font(null,Font.BOLD,33));
        profiletitle.setBounds(138,33,120,33);
        profiletitle.setForeground(Color.white);

        orderrecordtitle.setText("Order Record");
        orderrecordtitle.setFont(new Font(null,Font.BOLD,33));
        orderrecordtitle.setBounds(138,33,500,33);
        orderrecordtitle.setForeground(Color.white);
        orderrecordtitle.setVisible(false);

        addordertitle.setText("Add Order");
        addordertitle.setFont(new Font(null,Font.BOLD,33));
        addordertitle.setBounds(138,33,200,33);
        addordertitle.setForeground(Color.white);
        addordertitle.setVisible(false);

        employeetitle.setText("Employee");
        employeetitle.setFont(new Font(null,Font.BOLD,33));
        employeetitle.setBounds(138,33,200,33);
        employeetitle.setForeground(Color.white);
        employeetitle.setVisible(false);

        topspliterpanel.setBackground(new Color(57,60,73));
        topspliterpanel.setBounds(138,95,889,3);

        orderrecordspliter.setBackground(new Color(57,60,73));
        orderrecordspliter.setBounds(120,405,932,1);
        orderrecordspliter.setVisible(false);

        infoimagelabel.setIcon(infopanelimg);
        infoimagelabel.setBounds(197,181,184,178);

        salaryimagelabel.setIcon(salarypanelimg);
        salaryimagelabel.setBounds(534,182,85,85);

        contratimagelabel.setIcon(contratpanelimg);
        contratimagelabel.setBounds(523,460,85,85);

        totrevimagelabel.setIcon(totalrevenueimg);
        totrevimagelabel.setBounds(156,133,34,34);
        totrevimagelabel.setVisible(false);

        totordimagelabel.setIcon(totalordersimg);
        totordimagelabel.setBounds(487,133,34,34);
        totordimagelabel.setVisible(false);

        topordimagelabel.setIcon(toporderimg);
        topordimagelabel.setBounds(793,133,34,34);
        topordimagelabel.setVisible(false);

        userfirstnamelable.setText(e.firstName);
        userfirstnamelable.setForeground(Color.white);
        userfirstnamelable.setFont(new Font(null,Font.BOLD,27));
        userfirstnamelable.setBounds(197,393,250,27);

        firstnamelable.setText("First Name");
        firstnamelable.setForeground(lightgray);
        firstnamelable.setFont(new Font(null,Font.BOLD,13));
        firstnamelable.setBounds(197,422,250,13);

        userlastnamelable.setText(e.lastName);
        userlastnamelable.setForeground(Color.white);
        userlastnamelable.setFont(new Font(null,Font.BOLD,27));
        userlastnamelable.setBounds(197,458,250,27);

        lastnamelable.setText("Last Name");
        lastnamelable.setForeground(lightgray);
        lastnamelable.setFont(new Font(null,Font.BOLD,13));
        lastnamelable.setBounds(197,488,250,13);

        useragelable.setText(String.valueOf(e.age));
        useragelable.setForeground(Color.white);
        useragelable.setFont(new Font(null,Font.BOLD,27));
        useragelable.setBounds(197,525,250,27);

        agelable.setText("Age");
        agelable.setForeground(lightgray);
        agelable.setFont(new Font(null,Font.BOLD,13));
        agelable.setBounds(197,556,250,13);

        userroleidlable.setText(String.valueOf(e.id));
        userroleidlable.setForeground(Color.white);
        userroleidlable.setFont(new Font(null,Font.BOLD,27));
        userroleidlable.setBounds(197,591,250,27);

        roleidlable.setText("Logged in user ID");
        roleidlable.setForeground(lightgray);
        roleidlable.setFont(new Font(null,Font.BOLD,13));
        roleidlable.setBounds(197,621,250,13);

        usersalarylable.setText(String.valueOf(e.salary));
        usersalarylable.setForeground(Color.white);
        usersalarylable.setFont(new Font(null,Font.BOLD,54));
        usersalarylable.setBounds(533,292,500,80);

        salarylable.setText("Salary");
        salarylable.setForeground(lightgray);
        salarylable.setFont(new Font(null,Font.BOLD,34));
        salarylable.setBounds(648,236,300,40);

        usercontratlable.setText(e.contratType);
        usercontratlable.setForeground(Color.white);
        usercontratlable.setFont(new Font(null,Font.BOLD,54));
        usercontratlable.setBounds(533,562,500,80);

        contratlable.setText("Contrat type");
        contratlable.setForeground(lightgray);
        contratlable.setFont(new Font(null,Font.BOLD,34));
        contratlable.setBounds(640,512,300,40);

        usertotalorder.setText("500");
        usertotalorder.setForeground(Color.white);
        usertotalorder.setFont(new Font(null,Font.BOLD,27));
        usertotalorder.setBounds(489,172,300,27);
        usertotalorder.setVisible(false);

        totalorder.setText("Total Orders");
        totalorder.setForeground(lightgray);
        totalorder.setFont(new Font(null,Font.BOLD,13));
        totalorder.setBounds(489,218,250,13);
        totalorder.setVisible(false);

        usertotalrevenue.setText("$20,000");
        usertotalrevenue.setForeground(Color.white);
        usertotalrevenue.setFont(new Font(null,Font.BOLD,27));
        usertotalrevenue.setBounds(158,172,300,27);
        usertotalrevenue.setVisible(false);

        totalrevenue.setText("Total Revenue");
        totalrevenue.setForeground(lightgray);
        totalrevenue.setFont(new Font(null,Font.BOLD,13));
        totalrevenue.setBounds(158,218,250,13);
        totalrevenue.setVisible(false);

        usertoporder.setText("Tibs");
        usertoporder.setForeground(Color.white);
        usertoporder.setFont(new Font(null,Font.BOLD,27));
        usertoporder.setBounds(793,172,300,27);
        usertoporder.setVisible(false);

        toporder.setText("Top Orders");
        toporder.setForeground(lightgray);
        toporder.setFont(new Font(null,Font.BOLD,13));
        toporder.setBounds(793,218,250,13);
        toporder.setVisible(false);

        useraddstotalrevenue.setText("1,000,000");
        useraddstotalrevenue.setForeground(Color.white);
        useraddstotalrevenue.setFont(new Font(null,Font.BOLD,27));
        useraddstotalrevenue.setBounds(151,234,300,27);
        useraddstotalrevenue.setVisible(false);

        addstotalevenue.setText("Total Revenue");
        addstotalevenue.setForeground(lightgray);
        addstotalevenue.setFont(new Font(null,Font.BOLD,13));
        addstotalevenue.setBounds(151,268,300,27);
        addstotalevenue.setVisible(false);


        useraddstotalorder.setForeground(Color.white);
        useraddstotalorder.setFont(new Font(null,Font.BOLD,27));
        useraddstotalorder.setBounds(469,234,300,27);
        useraddstotalorder.setVisible(false);

        addstotalorder.setText("Total Order");
        addstotalorder.setForeground(lightgray);
        addstotalorder.setFont(new Font(null,Font.BOLD,13));
        addstotalorder.setBounds(469,268,300,27);
        addstotalorder.setVisible(false);

        usercustomername.setText("Customer Name");
        usercustomername.setForeground(Color.white);
        usercustomername.setFont(new Font(null,Font.BOLD,27));
        usercustomername.setBounds(113,127,250,27);
        usercustomername.setVisible(false);

        date.setText("Tusday ,2,Febuary,2022");
        date.setForeground(lightgray);
        date.setFont(new Font(null,Font.BOLD,16));
        date.setBounds(113,162,250,16);
        date.setVisible(false);

        foodlabel.setText("Food");
        foodlabel.setForeground(lightred);
        foodlabel.setFont(new Font(null,Font.BOLD,20));
        foodlabel.setBounds(130,358,200,20);
        foodlabel.setVisible(false);

        coffelabel.setText("Coffe");
        coffelabel.setForeground(lightred);
        coffelabel.setFont(new Font(null,Font.BOLD,20));
        coffelabel.setBounds(454,358,200,20);
        coffelabel.setVisible(false);

        drinklabel.setText("Drinks");
        drinklabel.setForeground(lightred);
        drinklabel.setFont(new Font(null,Font.BOLD,20));
        drinklabel.setBounds(130,444,200,20);
        drinklabel.setVisible(false);

        disertlabel.setText("Disert");
        disertlabel.setForeground(lightred);
        disertlabel.setFont(new Font(null,Font.BOLD,20));
        disertlabel.setBounds(454,444,200,20);
        disertlabel.setVisible(false);

        orderreport.setText("Order Report");
        orderreport.setForeground(Color.white);
        orderreport.setFont(new Font(null,Font.BOLD,18));
        orderreport.setBounds(145,315,250,18);
        orderreport.setVisible(false);

        item.setText("Order Id");
        item.setForeground(Color.white);
        item.setFont(new Font(null,Font.BOLD,13));
        item.setBounds(123,379,250,13);
        item.setVisible(false);

        orderid.setText("Order Name");
        orderid.setForeground(Color.white);
        orderid.setFont(new Font(null,Font.BOLD,13));
        orderid.setBounds(270,379,250,13);
        orderid.setVisible(false);

        price.setText("Catagory");
        price.setForeground(Color.white);
        price.setFont(new Font(null,Font.BOLD,13));
        price.setBounds(430,379,250,13);
        price.setVisible(false);

        employeename.setText("Quantity");
        employeename.setForeground(Color.white);
        employeename.setFont(new Font(null,Font.BOLD,13));
        employeename.setBounds(580,379,250,13);
        employeename.setVisible(false);





        orderPrice.setText("Price");
        orderPrice.setForeground(Color.white);
        orderPrice.setFont(new Font(null,Font.BOLD,13));
        orderPrice.setBounds(730,379,250,13);
        orderPrice.setVisible(false);




        orderDescription.setText("Cashier");
        orderDescription.setForeground(Color.white);
        orderDescription.setFont(new Font(null,Font.BOLD,13));
        orderDescription.setBounds(880,379,250,13);
        orderDescription.setVisible(false);



        food.setBounds(113,381,283,47);
        food.setFont(new Font(null,Font.BOLD,15));
        food.setForeground(lightgray);
        food.setSelectedIndex(-1);
        food.setBackground(darkblue);
        food.addActionListener(this);
        food.setVisible(false);

        coffe.setBounds(438,381,283,47);
        coffe.setFont(new Font(null,Font.BOLD,15));
        coffe.setSelectedIndex(-1);
        coffe.setForeground(lightgray);
        coffe.setBackground(darkblue);
        coffe.addActionListener(this);
        coffe.setVisible(false);

        drinks.setBounds(113,465,283,47);
        drinks.setFont(new Font(null,Font.BOLD,15));
        drinks.setSelectedIndex(-1);
        drinks.setForeground(lightgray);
        drinks.setBackground(darkblue);
        drinks.addActionListener(this);
        drinks.setVisible(false);

        disert.setBounds(438,465,283,47);
        disert.setFont(new Font(null,Font.BOLD,15));
        disert.setSelectedIndex(-1);
        disert.setForeground(lightgray);
        disert.setBackground(darkblue);
        disert.addActionListener(this);
        disert.setVisible(false);

        addsitem.setText("Item");
        addsitem.setFont(new Font(null,Font.BOLD,13));
        addsitem.setForeground(Color.white);
        addsitem.setBounds(789,146,150,13);
        addsitem.setVisible(false);

        quantity.setText("Qty");
        quantity.setFont(new Font(null,Font.BOLD,13));
        quantity.setForeground(Color.white);
        quantity.setBounds(972,146,150,13);
        quantity.setVisible(false);

        addsprice.setText("Price");
        addsprice.setFont(new Font(null,Font.BOLD,13));
        addsprice.setForeground(Color.white);
        addsprice.setBounds(1033,146,150,13);
        addsprice.setVisible(false);

        order.setText("Ordered");
        order.setFont(new Font(null,Font.BOLD,20));
        order.setForeground(lightgray);
        order.setBounds(789,33,150,20);
        order.setVisible(false);

        useraddsorder.setText("   Services list");
        useraddsorder.setFont(new Font(null,Font.BOLD,20));
        useraddsorder.setForeground(lightgray);
        useraddsorder.setBounds(854,33,150,20);
        useraddsorder.setVisible(false);

        addstotal.setText("Total");
        addstotal.setFont(new Font(null,Font.BOLD,13));
        addstotal.setForeground(Color.white);
        addstotal.setBounds(789,692,150,13);
        addstotal.setVisible(false);

        //sub total price
        useraddstotal.setText("0");
        useraddstotal.setFont(new Font(null,Font.BOLD,13));
        useraddstotal.setForeground(lightgray);
        useraddstotal.setBounds(1022,692,150,13);
        useraddstotal.setVisible(false);

        personinfopanel.setBackground(darkblue);
        personinfopanel.setBounds(127,141,322,613);
        personinfopanel.setRoundTopLeft(78);
        personinfopanel.setRoundTopRight(78);
        personinfopanel.setRoundBottomLeft(78);
        personinfopanel.setRoundBottomRight(78);

        personsalarypanel.setBackground(darkblue);
        personsalarypanel.setBounds(492,141,538,260);
        personsalarypanel.setRoundTopLeft(68);
        personsalarypanel.setRoundTopRight(68);
        personsalarypanel.setRoundBottomLeft(68);
        personsalarypanel.setRoundBottomRight(68);

        personcontratpanel.setBackground(darkblue);
        personcontratpanel.setBounds(492,418,538,339);
        personcontratpanel.setRoundTopLeft(68);
        personcontratpanel.setRoundTopRight(68);
        personcontratpanel.setRoundBottomLeft(68);
        personcontratpanel.setRoundBottomRight(68);

        orderrecordpopularpanel.setBackground(darkblue);
        orderrecordpopularpanel.setBounds(777,120,278,136);
        orderrecordpopularpanel.setRoundTopLeft(17);
        orderrecordpopularpanel.setRoundTopRight(17);
        orderrecordpopularpanel.setRoundBottomLeft(17);
        orderrecordpopularpanel.setRoundBottomRight(17);
        orderrecordpopularpanel.setVisible(false);

        orderrecorddatapanel.setBackground(darkblue);
        orderrecorddatapanel.setBounds(120,290,932,485);
        orderrecorddatapanel.setRoundTopLeft(18);
        orderrecorddatapanel.setRoundTopRight(18);
        orderrecorddatapanel.setRoundBottomLeft(18);
        orderrecorddatapanel.setRoundBottomRight(18);
        orderrecorddatapanel.setVisible(false);

        orderrecordtotaliteampanel.setBackground(darkblue);
        orderrecordtotaliteampanel.setBounds(456,120,283,136);
        orderrecordtotaliteampanel.setRoundTopLeft(17);
        orderrecordtotaliteampanel.setRoundTopRight(17);
        orderrecordtotaliteampanel.setRoundBottomLeft(17);
        orderrecordtotaliteampanel.setRoundBottomRight(17);
        orderrecordtotaliteampanel.setVisible(false);

        orderrecordtotalpanel.setBackground(darkblue);
        orderrecordtotalpanel.setBounds(120,120,283,136);
        orderrecordtotalpanel.setRoundTopLeft(17);
        orderrecordtotalpanel.setRoundTopRight(17);
        orderrecordtotalpanel.setRoundBottomLeft(17);
        orderrecordtotalpanel.setRoundBottomRight(17);
        orderrecordtotalpanel.setVisible(false);

        addstotalrevenuepanel.setBackground(darkblue);
        addstotalrevenuepanel.setBounds(113,210,283,136);
        addstotalrevenuepanel.setRoundTopLeft(17);
        addstotalrevenuepanel.setRoundTopRight(17);
        addstotalrevenuepanel.setRoundBottomLeft(17);
        addstotalrevenuepanel.setRoundBottomRight(17);
        addstotalrevenuepanel.setVisible(false);

        addstotalorderpanel.setBackground(darkblue);
        addstotalorderpanel.setBounds(438,210,283,136);
        addstotalorderpanel.setRoundTopLeft(17);
        addstotalorderpanel.setRoundTopRight(17);
        addstotalorderpanel.setRoundBottomLeft(17);
        addstotalorderpanel.setRoundBottomRight(17);
        addstotalorderpanel.setVisible(false);

        addsrightorderpanel.setBackground(darkblue);
        addsrightorderpanel.setBounds(753,0,327,825);
        addsrightorderpanel.setVisible(false);

        employeeleftpanel.setBackground(darkblue);
        employeeleftpanel.setBounds(138,113,265,665);
        employeeleftpanel.setRoundTopLeft(15);
        employeeleftpanel.setRoundTopRight(15);
        employeeleftpanel.setRoundBottomLeft(15);
        employeeleftpanel.setRoundBottomRight(15);
        employeeleftpanel.setVisible(false);

        employeerightpanel.setBackground(darkblue);
        employeerightpanel.setBounds(429,113,644,665);
        employeerightpanel.setRoundTopLeft(15);
        employeerightpanel.setRoundTopRight(15);
        employeerightpanel.setRoundBottomLeft(15);
        employeerightpanel.setRoundBottomRight(15);
        employeerightpanel.setVisible(false);

        addssplit.setBackground(new Color(57,60,73));
        addssplit.setBounds(772,183,304,2);
        addssplit.setVisible(false);

        orderrecordtable.setTableHeader(null);
        orderrecordtable.setForeground(lightgray);
        orderrecordtable.setFont(new Font(null,Font.BOLD,13));
        orderrecordtable.setBackground(darkblue);
        orderrecordtable.setRowHeight(50);
        orderrecordtable.setShowGrid(false);
        orderrecordtable.setBorder(BorderFactory.createEmptyBorder());
        orderrecordtable.setEnabled(false);

        employeetable.setTableHeader(null);
        employeetable.setForeground(lightgray);
        employeetable.setFont(new Font(null,Font.BOLD,13));
        employeetable.setBackground(darkblue);
        employeetable.setRowHeight(50);
        employeetable.setShowGrid(false);
        employeetable.setBorder(BorderFactory.createEmptyBorder());
        employeetable.setEnabled(false);

        orderrecordscrollpanel.setBackground(darkblue);
        orderrecordscrollpanel.getViewport().setBackground(darkblue);
        orderrecordscrollpanel.setBounds(120,407,932,364);
        orderrecordscrollpanel.setBorder(null);
        orderrecordscrollpanel.setVisible(false);

        employeescrollpanel.setBackground(darkblue);
        employeescrollpanel.getViewport().setBackground(darkblue);
        employeescrollpanel.setBounds(429,255,644,523);
        employeescrollpanel.setBorder(null);
        employeescrollpanel.setVisible(false);

        logop.setIcon(logo);
        logop.setBounds(20,21,55,55);

        sidepanel.setBackground(darkblue);
        sidepanel.setBounds(0, 0, 94, 800);
        sidepanel.setLayout(null);
        sidepanel.add(logop);

        s2background.setBackground(lightdarkblue);
        s2background.setBounds(0,0,1081,800);

        layer.setBounds(0, 0, 1081, 800);
        layer.add(personbutton);
        layer.add(personclickedbackground);
        layer.add(personclickedbuttonbackground);
        layer.add(orderbutton);
        layer.add(orderclickedbackground);
        layer.add(orderclickedbuttonbackground);
        layer.add(addbutton);
        layer.add(addclickedbackground);
        layer.add(addclickedbuttonbackground);
        layer.add(employeebutton);
        layer.add(employeeclickedbackground);
        layer.add(employeeclickedbuttonbackground);
        layer.add(exitbutton);
        layer.add(exitclickedbackground);
        layer.add(addtheorderrecord);
        layer.add(sidepanel);

        layer.add(userfirstnamelable);
        layer.add(firstnamelable);
        layer.add(userlastnamelable);
        layer.add(lastnamelable);
        layer.add(useragelable);
        layer.add(agelable);
        layer.add(userroleidlable);
        layer.add(roleidlable);
        layer.add(salarylable);
        layer.add(usersalarylable);
        layer.add(contratlable);
        layer.add(usercontratlable);


        layer.add(infoimagelabel);
        layer.add(salaryimagelabel);
        layer.add(contratimagelabel);

        layer.add(personinfopanel);
        layer.add(personsalarypanel);
        layer.add(personcontratpanel);
        layer.add(profiletitle);

        layer.add(orderrecordscrollpanel);
        layer.add(employeename);
        layer.add(orderPrice);
        layer.add(orderDescription);
        layer.add(price);
        layer.add(orderid);
        layer.add(item);
        layer.add(orderreport);
        layer.add(orderrecordspliter);
        layer.add(toporder);
        layer.add(usertoporder);
        layer.add(totalrevenue);
        layer.add(usertotalrevenue);
        layer.add(totalorder);
        layer.add(usertotalorder);
        layer.add(topordimagelabel);
        layer.add(totordimagelabel);
        layer.add(totrevimagelabel);
        layer.add(orderrecordpopularpanel);
        layer.add(orderrecorddatapanel);
        layer.add(orderrecordtotalpanel);
        layer.add(orderrecordtotaliteampanel);
        layer.add(orderrecordtitle);

        layer.add(foodlabel);
        layer.add(coffelabel);
        layer.add(drinklabel);
        layer.add(disertlabel);
        layer.add(food);
        layer.add(coffe);
        layer.add(drinks);
        layer.add(disert);
        layer.add(date);
        layer.add(useraddstotal);
        layer.add(addstotal);
        layer.add(useraddsorder);
        layer.add(order);
        layer.add(quantity1);
        layer.add(quantity2);
        layer.add(quantity3);
        layer.add(quantity4);
        layer.add(itemprice1);
        layer.add(itemprice2);
        layer.add(itemprice3);
        layer.add(itemprice4);
        layer.add(price1);
        layer.add(price2);
        layer.add(price3);
        layer.add(price4);
        layer.add(choice1);
        layer.add(choice2);
        layer.add(choice3);
        layer.add(choice4);
        layer.add(removebutton1);
        layer.add(removebutton2);
        layer.add(removebutton3);
        layer.add(removebutton4);
        layer.add(addsitem);
        layer.add(quantity);
        layer.add(addsprice);
        layer.add(addstotalorder);
        layer.add(useraddstotalorder);
        layer.add(addstotalevenue);
        layer.add(useraddstotalrevenue);
        layer.add(addstotalorderpanel);
        layer.add(addstotalrevenuepanel);
        layer.add(usercustomername);
        layer.add(addssplit);
        layer.add(addsrightorderpanel);
        layer.add(addordertitle);

        layer.add(employeescrollpanel);

        layer.add(aeeditemployeebutton);
        layer.add(aeaddemployebutton);
        layer.add(esmallrole);
        layer.add(esmallage);
        layer.add(esmallgender);
        layer.add(esmallname);
        layer.add(role);
        layer.add(erole);
        layer.add(female);
        layer.add(male);
        layer.add(egender);
        layer.add(year);
        layer.add(month);
        layer.add(day);
        layer.add(edateofbirth);
        layer.add(elastname);
        layer.add(efirstname);
        layer.add(found);
        layer.add(employees);
        layer.add(eaddedit);
        layer.add(lastname);
        layer.add(firstname);
        layer.add(searchbutton);
        layer.add(search);
        layer.add(listemployeebutton);
        layer.add(addemployebutton);
        layer.add(employeerightpanel);
        layer.add(employeeleftpanel);
        layer.add(employeetitle);

        layer.add(topspliterpanel);
        layer.add(s2background);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(scrlog.getImage());
        this.setSize(1095,825);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Cafe Managment System");
        this.add(layer);
    }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

private double getPrice(Service[] s,String name){
        Double price = 0.0;
        for(int i=0 ; i<s.length ; i++) {
            if (s[i].name.equals( name ) ) {
                price = s[i].singlePrice;
                break;
            }
        }
        return price;
}

    private void getserviceId(Order o,Service[] s,String name){
        Double price = 0.0;
        for(int i=0 ; i<s.length ; i++) {
            if (s[i].name.equals( name ) ) {
                o.serviceId = s[i].id;
                break;
            }
        }
    }

    private String[][] getOrderData(Order ord[][]) {
        int size = ord[0][0].arrySize;
        String[][] data = new String [size][6];

        for (int i = 0; i < size; i++) {
            data[i][0] = String.valueOf(ord[i][0].id);
            data[i][1] = ord[i][0].name;
            data[i][2] = ord[i][0].catagory;
            data[i][3] = String.valueOf(ord[i][0].quantity);
            data[i][4] = String.valueOf(ord[i][0].singlePrice * ord[i][0].quantity);
            data[i][5] = ord[i][0].cashierName;
        }
        return data;
    }
    private String[][] getEmployeeData(Employee[][] ord) {

        String[][] data = new String [ord.length][6];

        for (int i = 0; i < ord.length ; i++) {
            data[i][0] = String.valueOf(ord[i][0].id);
            data[i][1] = ord[i][0].firstName;
            data[i][2] = ord[i][0].lastName;
            data[i][3] = String.valueOf(ord[i][0].position);
            data[i][4] = String.valueOf(ord[i][0].salary);
            data[i][5] = ord[i][0].date;
        }
        return data;
    }

    private String[] getserviceData(Service[] name) {
        int x = name.length;
        String[] data = new String [x];

        for (int i = 0; i < x; i++) {
            data[i] = name[i].name;
        }
        return data;
    }

    void Pr() {
        psvisible(true);
        osvisible(false);
        asvisible(false);
        esvisible(false);
        es2visible(false);
    }
    void orderrecordscreen() {
        psvisible(false);
        osvisible(true);
        asvisible(false);
        esvisible(false);
        es2visible(false);
    }
    void addorderscreen(){
        psvisible(false);
        osvisible(false);
        asvisible(true);
        esvisible(false);
        es2visible(false);
    }
    void employeescreen() {
        psvisible(false);
        osvisible(false);
        asvisible(false);
        esvisible(true);
        es2visible(false);
    }
    void employeescreen2() {
        es2visible(true);
    }
    void psvisible(boolean x) {
        profiletitle.setVisible(x);
        userfirstnamelable.setVisible(x);
        firstnamelable.setVisible(x);
        userlastnamelable.setVisible(x);
        lastnamelable.setVisible(x);
        useragelable.setVisible(x);
        agelable.setVisible(x);
        userroleidlable.setVisible(x);
        roleidlable.setVisible(x);
        salarylable.setVisible(x);
        usersalarylable.setVisible(x);
        contratlable.setVisible(x);
        usercontratlable.setVisible(x);
        infoimagelabel.setVisible(x);
        salaryimagelabel.setVisible(x);
        contratimagelabel.setVisible(x);
        personinfopanel.setVisible(x);
        personsalarypanel.setVisible(x);
        personcontratpanel.setVisible(x);
        personclickedbuttonbackground.setVisible(x);
        personclickedbackground.setVisible(x);
        if (x==true) {
            personclickedbackground.setBackground(lightred);
            personbutton.setIcon(personc);
        }
        else {
            personbutton.setIcon(person);
        }
    }
    void osvisible(boolean x) {
        orderrecordtitle.setVisible(x);
        orderrecordspliter.setVisible(x);
        totrevimagelabel.setVisible(x);
        totordimagelabel.setVisible(x);
        topordimagelabel.setVisible(x);
        usertotalorder.setVisible(x);
        totalorder.setVisible(x);
        usertotalrevenue.setVisible(x);
        totalrevenue.setVisible(x);
        usertoporder.setVisible(x);
        toporder.setVisible(x);
        orderreport.setVisible(x);
        item.setVisible(x);
        orderid.setVisible(x);
        price.setVisible(x);
        employeename.setVisible(x);
        orderDescription.setVisible(x);
        orderPrice.setVisible(x);
        orderrecordpopularpanel.setVisible(x);
        orderrecorddatapanel.setVisible(x);
        orderrecordtotaliteampanel.setVisible(x);
        orderrecordtotalpanel.setVisible(x);
        orderrecordscrollpanel.setVisible(x);
        orderclickedbackground.setVisible(x);
        orderclickedbuttonbackground.setVisible(x);
        if(x==false) {
            orderbutton.setIcon(orderr);
        }else {
            orderbutton.setIcon(orderrc);
            orderclickedbackground.setBackground(lightred);
        }

    }
    void asvisible(boolean x){
        addclickedbackground.setVisible(x);
        addclickedbuttonbackground.setVisible(x);
        useraddstotalrevenue.setVisible(x);
        addstotalevenue.setVisible(x);
        useraddstotalorder.setVisible(x);
        addstotalorder.setVisible(x);
        usercustomername.setVisible(x);
        date.setVisible(x);
        foodlabel.setVisible(x);
        coffelabel.setVisible(x);
        drinklabel.setVisible(x);
        disertlabel.setVisible(x);
        food.setVisible(x);
        coffe.setVisible(x);
        drinks.setVisible(x);
        disert.setVisible(x);
        addsitem.setVisible(x);
        quantity.setVisible(x);
        addsprice.setVisible(x);
        order.setVisible(x);
        useraddsorder.setVisible(x);
        addstotal.setVisible(x);
        useraddstotal.setVisible(x);
        addstotalrevenuepanel.setVisible(x);
        addstotalorderpanel.setVisible(x);
        addsrightorderpanel.setVisible(x);
        addssplit.setVisible(x);
        addordertitle.setVisible(x);
        if(x==false) {
            addbutton.setIcon(addo);
            allchoicev();

        }else {
            addbutton.setIcon(addoc);
            addclickedbackground.setBackground(lightred);
        }
    }
    void esvisible(boolean x) {

        employeeclickedbackground.setVisible(x);
        employeeclickedbuttonbackground.setVisible(x);
        eaddedit.setVisible(x);
        found.setVisible(x);
        search.setVisible(x);
        searchbutton.setVisible(x);
        efirstname.setVisible(x);
        firstname.setVisible(x);
        elastname.setVisible(x);
        lastname.setVisible(x);
        edateofbirth.setVisible(x);
        day.setVisible(x);
        month.setVisible(x);
        year.setVisible(x);
        egender.setVisible(x);
        male.setVisible(x);
        female.setVisible(x);
        erole.setVisible(x);
        role.setVisible(x);
        aeaddemployebutton.setVisible(x);
       // aeeditemployeebutton.setVisible(x);
        addemployebutton.setContentAreaFilled(x);
        addemployebutton.setVisible(x);
        addemployebutton.setForeground(lightred);
        addemployebutton.setIcon(addec);
        listemployeebutton.setVisible(x);
        listemployeebutton.setForeground(Color.white);
        listemployeebutton.setIcon(liste);
        employeerightpanel.setVisible(x);
        employeeleftpanel.setVisible(x);
        employeetitle.setVisible(x);
        if(x==false) {
            employeebutton.setIcon(employeescr);
            allchoicev();

        }else {
            employeebutton.setIcon(employeescrc);
            employeeclickedbackground.setBackground(lightred);
        }
    }

    //display all employee
    void es2visible(boolean x) {

        if(x==true&& employeeclickedbackground.isVisible()==true) {
            employees.setVisible(x);
            esmallname.setVisible(x);
            esmallgender.setVisible(x);
            esmallage.setVisible(x);
            esmallrole.setVisible(x);
            employeescrollpanel.setVisible(x);

            eaddedit.setVisible(!x);
            found.setVisible(!x);
            search.setVisible(!x);
            searchbutton.setVisible(!x);
            efirstname.setVisible(!x);
            firstname.setVisible(!x);
            elastname.setVisible(!x);
            lastname.setVisible(!x);
            edateofbirth.setVisible(!x);
            day.setVisible(!x);
            month.setVisible(!x);
            year.setVisible(!x);
            egender.setVisible(!x);
            male.setVisible(!x);
            female.setVisible(!x);
            erole.setVisible(!x);
            role.setVisible(!x);
            aeaddemployebutton.setVisible(!x);
            aeeditemployeebutton.setVisible(!x);
            addemployebutton.setContentAreaFilled(!x);
            addemployebutton.setForeground(Color.white);
            addemployebutton.setIcon(adde);
            listemployeebutton.setContentAreaFilled(x);
            listemployeebutton.setForeground(lightred);
            listemployeebutton.setIcon(listec);
        }
        if(x==false) {
            employees.setVisible(x);
            esmallname.setVisible(x);
            esmallgender.setVisible(x);
            esmallage.setVisible(x);
            esmallrole.setVisible(x);
            employeescrollpanel.setVisible(x);
            listemployeebutton.setContentAreaFilled(x);
        }
        if(x==false&& employeeclickedbackground.isVisible()==true) {
            employees.setVisible(x);
            esmallname.setVisible(x);
            esmallgender.setVisible(x);
            esmallage.setVisible(x);
            esmallrole.setVisible(x);
            employeescrollpanel.setVisible(x);
            esvisible(!x);
        }
    }
    void choice1v(boolean x) {
        removebutton1.setVisible(x);
        price1.setVisible(x);
        quantity1.setVisible(x);
        itemprice1.setVisible(x);
        choice1.setVisible(x);
        if(x==true) {
            addtheorderrecord.setVisible(x);
            addorderrecrdbuButton.setVisible(x);
        }
        if(x==false&&choice2.isVisible()==false&&choice3.isVisible()==false&&choice4.isVisible()==false) {
            addtheorderrecord.setVisible(x);
            addorderrecrdbuButton.setVisible(x);
        }
    }
    void choice2v(boolean x) {
        removebutton2.setVisible(x);
        price2.setVisible(x);
        quantity2.setVisible(x);
        itemprice2.setVisible(x);
        choice2.setVisible(x);
        if(x==true) {
            addtheorderrecord.setVisible(x);
            addorderrecrdbuButton.setVisible(x);
        }
        if(x==false&&choice1.isVisible()==false&&choice3.isVisible()==false&&choice4.isVisible()==false) {
            addtheorderrecord.setVisible(x);
            addorderrecrdbuButton.setVisible(x);
        }
    }
    void choice3v(boolean x) {
        removebutton3.setVisible(x);
        price3.setVisible(x);
        quantity3.setVisible(x);
        itemprice3.setVisible(x);
        choice3.setVisible(x);
        if(x==true) {
            addtheorderrecord.setVisible(x);
            addorderrecrdbuButton.setVisible(x);
        }
        if(x==false&&choice2.isVisible()==false&&choice1.isVisible()==false&&choice4.isVisible()==false) {
            addtheorderrecord.setVisible(x);
            addorderrecrdbuButton.setVisible(x);
        }
    }
    void choice4v(boolean x) {
        removebutton4.setVisible(x);
        price4.setVisible(x);
        quantity4.setVisible(x);
        itemprice4.setVisible(x);
        choice4.setVisible(x);
        if(x==true) {
            addtheorderrecord.setVisible(x);
            addorderrecrdbuButton.setVisible(x);
        }
        if(x==false&&choice2.isVisible()==false&&choice3.isVisible()==false&&choice1.isVisible()==false) {
            addtheorderrecord.setVisible(x);
            addorderrecrdbuButton.setVisible(x);
        }
    }
    void allchoicev() {
        choice1v(false);
        choice2v(false);
        choice3v(false);
        choice4v(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==personbutton&&personclickedbackground.isVisible()==false) {
            personclickedbackground.setBackground(new Color(37,40,54));
            personclickedbackground.setVisible(true);
        }
        if(e.getSource()==orderbutton&&orderclickedbackground.isVisible()==false) {
            orderclickedbackground.setBackground(new Color(37,40,54));
            orderclickedbackground.setVisible(true);
        }
        if(e.getSource()==addbutton&&addclickedbackground.isVisible()==false) {
            addclickedbackground.setBackground(new Color(37,40,54));
            addclickedbackground.setVisible(true);
        }
        if(e.getSource()==employeebutton&&employeeclickedbackground.isVisible()==false) {
            employeeclickedbackground.setBackground(new Color(37,40,54));
            employeeclickedbackground.setVisible(true);
        }
        if (e.getSource()==exitbutton) {
            exitclickedbackground.setVisible(true);
        }
        if (e.getSource()==removebutton1) {
            removebutton1.setIcon(removeimgh);
        }
        if (e.getSource()==removebutton2) {
            removebutton2.setIcon(removeimgh);
        }
        if (e.getSource()==removebutton3) {
            removebutton3.setIcon(removeimgh);
        }
        if (e.getSource()==removebutton4) {
            removebutton4.setIcon(removeimgh);
        }

    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==personbutton&&personclickedbackground.getBackground()!=lightred) {
            personclickedbackground.setVisible(false);
        }
        if(e.getSource()==orderbutton&&orderclickedbackground.getBackground()!=lightred) {
            orderclickedbackground.setVisible(false);
        }
        if(e.getSource()==addbutton&&addclickedbackground.getBackground()!=lightred) {
            addclickedbackground.setVisible(false);
        }
        if(e.getSource()==employeebutton&&employeeclickedbackground.getBackground()!=lightred) {
            employeeclickedbackground.setVisible(false);
        }
        if (e.getSource()==exitbutton) {
            exitclickedbackground.setVisible(false);
        }
        if (e.getSource()==removebutton1) {
            removebutton1.setIcon(removeimg);
        }
        if (e.getSource()==removebutton2) {
            removebutton2.setIcon(removeimg);
        }
        if (e.getSource()==removebutton3) {
            removebutton3.setIcon(removeimg);
        }
        if (e.getSource()==removebutton4) {
            removebutton4.setIcon(removeimg);
        }
    }

    @Override
    public  void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        GetServices gServices = new GetServices();
        try {
            ServiceNames s = gServices.getServices();
            if (e.getSource() == personbutton) {
                Pr();
            }
            if (e.getSource() == orderbutton) {
                orderrecordscreen();
            }
            if (e.getSource() == addbutton) {
                addorderscreen();
            }
            if (e.getSource() == employeebutton) {
                employeescreen();
            }
            if (e.getSource() == exitbutton) {
                this.dispose();
                new S();
            }

            if (e.getSource() == food) {
                quantity1.setText("1");
                choice1.setText("" + food.getSelectedItem());
                choice1v(true);
                String sfood = (String) food.getSelectedItem();
                double price = getPrice(s.food, sfood);
                itemprice1.setText(String.valueOf(price));
                price1.setText(String.valueOf(Double.parseDouble(quantity1.getText()) * price));


                fp = Double.parseDouble(price1.getText());

            }
            if (e.getSource() == quantity1) {
                double foodPrice = getPrice(s.food, (String) food.getSelectedItem());
                price1.setText(String.valueOf(Double.parseDouble(quantity1.getText()) * foodPrice));
                useraddstotal.setText(String.valueOf(Double.parseDouble(useraddstotal.getText()) + Double.parseDouble(price1.getText())));

                fp = Double.parseDouble(price1.getText());

            }


            if (e.getSource() == coffe) {
                quantity2.setText("1");
                choice2.setText("" + coffe.getSelectedItem());
                choice2v(true);
                String scoffee = (String) coffe.getSelectedItem();
                double price = getPrice(s.coffee, scoffee);
                itemprice2.setText(String.valueOf(price));
                price2.setText(String.valueOf(Double.parseDouble(quantity2.getText()) * price));

                cp = Double.parseDouble(price2.getText());
            }
            if (e.getSource() == quantity2) {
                double coffeePrice = getPrice(s.coffee, (String) coffe.getSelectedItem());
                price2.setText(String.valueOf(Double.parseDouble(quantity2.getText()) * coffeePrice));

                cp = Double.parseDouble(price2.getText());
            }


            if (e.getSource() == drinks) {
                quantity3.setText("1");
                choice3.setText("" + drinks.getSelectedItem());
                choice3v(true);

                String sdrink = (String) drinks.getSelectedItem();
                double price = getPrice(s.drinks, sdrink);
                itemprice3.setText(String.valueOf(price));
                price3.setText(String.valueOf(Double.parseDouble(quantity3.getText()) * price));
                drp = Double.parseDouble(price3.getText());
            }
            if (e.getSource() == quantity3) {
                double drinkPrice = getPrice(s.drinks, (String) drinks.getSelectedItem());
                price3.setText(String.valueOf(Double.parseDouble(quantity3.getText()) * drinkPrice));
                System.out.println(drinkPrice + "is pric quantity is : " + quantity3.getText());
                drp = Double.parseDouble(price3.getText());
            }

            if (e.getSource() == disert) {
                quantity4.setText("1");
                choice4.setText("" + disert.getSelectedItem());
                choice4v(true);

                String sdrink = (String) disert.getSelectedItem();
                double price = getPrice(s.desert, sdrink);
                itemprice4.setText(String.valueOf(price));
                price4.setText(String.valueOf(Double.parseDouble(quantity4.getText()) * price));

                dep = Double.parseDouble(price4.getText());

            }
            if (e.getSource() == quantity4) {
                double drinkPrice = getPrice(s.desert, (String) disert.getSelectedItem());
                price4.setText(String.valueOf(Double.parseDouble(quantity4.getText()) * drinkPrice));
                System.out.println(drinkPrice + "is pric quantity is : " + quantity4.getText());
                dep = Double.parseDouble(price4.getText());
            }


            if (e.getSource() == addemployebutton) {
                employeescreen();
            }
            if (e.getSource() == listemployeebutton) {
                employeescreen2();
            }
            if (e.getSource() == removebutton1) {
                food.setSelectedIndex(-1);
                choice1v(false);
                price1.setText("0");

                fp = 0;
            }
            if (e.getSource() == removebutton2) {
                coffe.setSelectedIndex(-1);
                choice2v(false);
                price2.setText("0");

                cp = 0;
            }
            if (e.getSource() == removebutton3) {
                drinks.setSelectedIndex(-1);
                choice3v(false);
                price3.setText("0");

                drp = 0;
            }
            if (e.getSource() == removebutton4) {
                disert.setSelectedIndex(-1);
                choice4v(false);
                price4.setText("0");

                dep = 0;
            }
            //this if else if statment calculates the total price of the selected orders

            useraddstotal.setText(String.valueOf(dep + drp + cp + fp));


            if (e.getSource() == addorderrecrdbuButton) {
                Order o = new Order();

                o.employeeId = id;
                AddNewOrder addorder = new AddNewOrder();
                boolean success = true;
                if (food.isVisible()) {

                    System.out.println(id + " Is the id from visible food");

                    o.quantity = Integer.parseInt(quantity1.getText());
                    getserviceId(o, s.food, String.valueOf(food.getSelectedItem()));
                    success = addorder.addOrder(o);

                    tOrders += 1;
                }
                if (coffe.isVisible()) {
                    System.out.println(id + " Is the id from visible coffe");


                    o.quantity = Integer.parseInt(quantity2.getText());
                    getserviceId(o, s.coffee, String.valueOf(coffe.getSelectedItem()));
                    success = addorder.addOrder(o);

                    tOrders += 1;
                }
                if (drinks.isVisible()) {

                    o.quantity = Integer.parseInt(quantity3.getText());
                    getserviceId(o, s.drinks, (String) drinks.getSelectedItem());
                    System.out.println(o.serviceId + " Is the service id from visible drinks");
                    success = addorder.addOrder(o);

                    tOrders += 1;
                }
                if (disert.isVisible()) {
                    System.out.println(id + " Is the id from visible disert");

                    o.quantity = Integer.parseInt(quantity4.getText());
                    getserviceId(o, s.desert, String.valueOf(disert.getSelectedItem()));
                    success = addorder.addOrder(o);

                    tOrders += 1;
                }
                useraddstotalorder.setText(String.valueOf(tOrders));
                if (!success) {
                    JOptionPane.showMessageDialog(null, "Add order not successful !!!", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, " Add order successfull.", "success", JOptionPane.INFORMATION_MESSAGE);
                }

                if (choice1.isVisible()) {
                    System.out.println(choice1.getText());
                    food.setSelectedIndex(-1);
                }
                if (choice2.isVisible()) {
                    System.out.println(choice2.getText());
                    coffe.setSelectedIndex(-1);
                }
                if (choice3.isVisible()) {
                    System.out.println(choice3.getText());
                    drinks.setSelectedIndex(-1);
                }
                if (choice4.isVisible()) {
                    System.out.println(choice4.getText());
                    disert.setSelectedIndex(-1);
                }
                choice1v(false);
                choice2v(false);
                choice3v(false);
                choice4v(false);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//add/edit page
        GetEmployeeInfo ge = new GetEmployeeInfo();
Employee emp=new Employee();
        if (e.getSource() == searchbutton) {
            //setting fields to default value
            role.setSelectedIndex(-1);
            firstname.setText(" ");
            lastname.setText(" ");
            day.setSelectedIndex(-1);
            month.setSelectedIndex(-1);
            year.setSelectedIndex(-1);
            String searchbox = search.getText();
            System.out.println("the search box contains " + searchbox);
            if (isNumeric(searchbox)) {
                try {
                    int id = Integer.parseInt(search.getText());

                    boolean success = ge.getEmployeeInfo(emp,id);
                 if(success) {
                     found.setText("found");
                     aeeditemployeebutton.setVisible(true);
                     found.setForeground(Color.green);

                     firstname.setText(emp.firstName);
                     lastname.setText(emp.lastName);
                     if(emp.gender == "MALE") {
                         female.setSelected(false);
                     }
                     else if(emp.gender == "FEMALE"){
                         female.setSelected(true);
                     }

                     String d,m,y;
                     emp.date.trim();
                     d = "" + emp.date.charAt(8) + "" + emp.date.charAt(9);
                     m = "" + emp.date.charAt(5) + "" + emp.date.charAt(6);
                     y = "" + emp.date.charAt(0) + "" + emp.date.charAt(1) + "" + emp.date.charAt(2) + "" + emp.date.charAt(3);

                     role.setSelectedItem(emp.position);
                     day.setSelectedItem(d);
                month.setSelectedItem(m);
                year.setSelectedItem(y);
                 }
                 else {
                     aeeditemployeebutton.setVisible(false);
                     found.setText("not found");
                     found.setForeground(Color.red);
                     search.setText("");

                 }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        else {
                if (search.getText().isEmpty() ) {
                    found.setText(" ");
                    JOptionPane.showMessageDialog(null, "Empty text please Enter Id !!!", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    found.setText(" ");
                    JOptionPane.showMessageDialog(null, "Please Enter correct \n Employee Id contains numbers only !!!", "Error", JOptionPane.INFORMATION_MESSAGE);
                }

        }



        }
    }
}


