#include<conio.h>
#include<stdlib.h>
#include<iostream>
#include<string.h>
#include<ctime>
#include<windows.h>
using namespace std;
static int p=0;
static int r=0;
class metro
{
	public:
		char tr_no[5],driver[10];
		char arrival[5],from[10],to[10],seat[5][3][10];
	public:
	       	friend void assign1();
	       	void show();
	       	void show(char name[10]);
			void reserv();
			void empty();
			void cancel();
			void avail();
			void position(int i);
};
class admin:public metro
{
	protected:
	char name[10];
	char passwd[10];
	public:
	virtual	void assign()
	{
		system("cls");
		cout<<"enter admin name"<<endl;
		cin>>name;
		cout<<"enter admin password"<<endl;
		cin>>passwd;
	}	
}train[20];
class user:public admin
{
	char nam[10];
	char paswd[10];
	public:
	void assign()
	{
		cout<<"enter username"<<endl;
		cin>>nam;
		cout<<"enter password"<<endl;
		cin>>paswd;
	}
}user1[10];

void assign1()
{
	int n;
	system("cls");
	cout<<" enter train_no"<<endl;
	cin>>train[p].tr_no;
	for(n=0;n<p;n++)
	{
		if(strcmp(train[n].tr_no,train[p].tr_no)==0)
		{
				cout<<"alredy exits";
				exit(0);
		}
	}
	cout<<" enter driver"<<endl;
	cin>>train[p].driver;
	cout<<" enter arrival"<<endl;
	cin>>train[p].arrival;
	cout<<"from: "<<endl;
	cin>>train[p].from; 
	cout<<"to: "<<endl;
	cin>>train[p].to;
	train[p].empty();
	p++;
}

void metro::show(char name[10])
{
	int n;
       for( n=0;n<p;n++)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(strcmp(train[n].seat[i][j],name)==0)
				{
					cout<<"----------------------------------------------------"<<endl;
					cout<<"train no: "<<train[n].tr_no<<endl;
					cout<<"Driver: "<<train[n].driver<<endl;
					cout<<"Arrival time: "<<train[n].arrival<<endl;
					cout<<"From: "<<train[n].from<<endl;
					cout<<"To: "<<train[n].to<<endl;
					cout<<"--------------------------------------------------"<<endl;
				}
			}
		}
	}
	if(n>p)
	{
		cout<<"enter correct name:"<<endl;
	}
}


void metro::show()
{
  int n;
  char number[5];
  system("cls");
  cout<<"Enter train no: ";
  cin>>number;
  for(n=0;n<=p;n++)
  {
    if(strcmp(train[n].tr_no, number)==0)
    break;
  }
  while(n<=p)
  {
	cout<<"----------------------------------------------------"<<endl;
	cout<<"train no: "<<train[n].tr_no<<endl;
	cout<<"Driver: "<<train[n].driver<<endl;
	cout<<"Arrival time: "<<train[n].arrival<<endl;
	cout<<"From: "<<train[n].from<<endl;
	cout<<"To: "<<train[n].to<<endl;
	cout<<"-----------------------------------------------------";
	train[0].position(n);
	int a=1;
	for (int i=0; i<5; i++)
	{
		for(int j=0;j<3;j++)
		{
			a++;
			if(strcmp(train[n].seat[i][j],"Empty")!=0)
			cout<<"\nThe seat no "<<(a-1)<<" is reserved for "<<train[n].seat[i][j]<<".";
		}
	}
	break;
  }
	if(n>p)
	cout<<"Enter correct train no: ";
}

void metro::reserv()
{
  int seat,n;
  char number[5];
 system("cls");
  cout<<"train no: ";
  cin>>number;
  for(n=0;n<=p;n++)
  {
    if(strcmp(train[n].tr_no, number)==0)
    break;
  }
  while(n<=p)
  {
    cout<<"\nSeat Number: ";
    cin>>seat;
    if(seat>15)
    {
      cout<<"\nThere are only 15 seats available in this train.";
    }
    else
    {
	if (strcmp(train[n].seat[seat/3][(seat%3)-1], "Empty")==0)
	{
		cout<<"Enter passanger's name: ";
		cin>>train[n].seat[seat/3][(seat%3)-1];
		break;
	}
	else
	{
		cout<<"The seat no. is already reserved.\n";
	}
    }
  }
  if(n>p)
  {
      cout<<"Enter correct train no.\n";
  }
}

void metro::position(int l)
{
  int s=0;p=0;
  for (int i =0; i<5;i++)
  {
    cout<<"\n";
    for (int j = 0;j<3; j++)
    {
      s++;
      if(strcmp(train[l].seat[i][j], "Empty")==0)
      {
	  cout.width(5);
	  cout.fill(' ');
	  cout<<s<<".";
	  cout.width(10);
	  cout.fill(' ');
	  cout<<train[l].seat[i][j];
	  p++;
      }
      else
      {
	cout<<s<<". ";
	cout<<train[l].seat[i][j];
      }
    }
  }
	cout<<"\n\nThere are "<<p<<" seats empty in train No: "<<train[l].tr_no<<endl;
}

void metro::avail()
{

 system("cls");
 int n;
  for(n=0;n<p;n++)
  {
    cout<<"-------------------------------------"<<endl;
    cout<<"\ntrain no: "<<train[n].tr_no<<endl;
    cout<<"Driver: "<<train[n].driver<<endl;
    cout<<"Arrival time: "<<train[n].arrival<<endl;
    cout<<"From: "<<train[n].from<<endl;
    cout<<"To: "<<train[n].to<<endl;
    cout<<"-------------------------------------"<<endl;
  }	
}

void metro::empty()
{
  for(int i=0; i<5;i++)
  {
    for(int j=0;j<3;j++)
    {
      strcpy(train[p].seat[i][j], "Empty");
    }
  }
}

void metro::cancel()
{
	char name[10];
	cout<<"enter the name"<<endl;
	cin>>name;
	for(int n=0;n<p;n++)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(strcmp(train[n].seat[i][j],name)==0)
				{
					strcpy(train[n].seat[i][j], "Empty");
					cout<<"name deleted";
					break;
				}
			}
		}
	}
}
int main()
{
	admin *p1;
	admin a1;
	user u1;
	int ch,n,abc;
	char name[10];
	system("cls");
	system("color 0B");
	cout.width(30);
	cout<<"\n\n\n\n\n";
	cout<<"$$--WELCOME TO METRO REGISTRATION--$$"<<endl;
	//  FOR current time and date
	time_t now;	
	time (&now);
	cout<<ctime(&now)<<endl;         // For Displaying Date and Time	
	// Creating Object of Time

	cout<<"1-ADMIN\n2-USER\n";
	cin>>n;
	if(n==1)
	{
		int i;
		cout<<endl;
		cout<<endl;
		for (i=0; i<5; i++)
		{
			cout << "\xdb\xdb\xdb\xdb\xdb";
			Sleep(100);
		}
		Sleep(500);
		cout << endl << endl;
		system("cls");
		p1=&a1; 
		p1->assign();
		while(1)
		{
			cout.width(50);
			cout<<"\n\n\n1.Assign\n2.Reservation\n3.Show\n4.Train Available\n5.Search by name\n6.cancel\n7.Exit";
			cout<<"\nEnter your choice:-> ";
			cin>>ch;
			switch(ch)
			{
			    case 1: assign1();
				    break;
			    case 2: train[p].reserv();
				    break;
			    case 3: train[0].show();
				    break;
			    case 4: train[0].avail();
				    break;
			    case 5:cout<<"enter the name";
					cin>>name;
					train[0].show(name);
					break;
				case 6:	train[0].cancel();
						break;
			    case 7: exit(0);
			}
	
		}
	}
	if(n==2)
	{
		int i;
		cout<<endl;
		cout<<endl;
		for (i=0; i<5; i++)
		{
			cout << "\xdb\xdb\xdb\xdb\xdb";
			Sleep(100);
		}
		Sleep(500);
		cout << endl << endl;
		system("cls");
		cout<<"\n\n\n\n";
		p1=&u1;
	    p1->assign();
		while(1)
		{
			cout.width(50);
			cout<<"\n\n\n1.Reservation\n2.Show\n3.Train Available\n4.Search by name\n5.cancel\n6.Exit";
			cout<<"\nEnter your choice:-> ";
			cin>>ch;
			switch(ch)
			{
			    case 1:user1[p].reserv();
				    break;
			    case 2: user1[0].show();
				    break;
			    case 3: user1[0].avail();
				    break;
			    case 4:cout<<"enter the name";
					cin>>name;
					user1[0].show(name);
					break;
				case 5:user1[0].cancel();
					break;
			    case 6: exit(0);
				default:cout<<"no choice"<<endl;	
			}
		}
	}
	else
	{
		cout<<"no choice";
	}
	return 0;
}
