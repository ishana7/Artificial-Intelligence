package goalstack;
import java.util.StringTokenizer;

public class State 
{
	int blocks;
	int on[][];
	int ontable[];
	int clear[];
	int hold[];
	int arm;
	
	State(int blocks,String state_string)
	{
		this.blocks=blocks;
		on=new int[blocks][blocks];
		ontable=new int[blocks];
		clear=new int[blocks];
		hold=new int[blocks];
		arm=-1;
		setstate(state_string);
	}
	
	void setstate(String state_string)
	{
		//System.out.println(state_string);
		StringTokenizer st=new StringTokenizer(state_string,"^");
		String op[]=new String[st.countTokens()];
		int k=0;
		while(st.hasMoreTokens())
		{
			op[k]=st.nextToken();
			k++;
		}
		for(int i=0;i<k;i++)
		{
			StringTokenizer st_op=new StringTokenizer(op[i],"(,)");
			int l=0;
			String op1[]=new String[st_op.countTokens()];
			while(st_op.hasMoreTokens())
			{
				op1[l]=st_op.nextToken();
				l++;
			}
			//System.out.println(op1[0]);
			if(op1[0].equals("on"))
			{
				on[(int)op1[1].charAt(0)%97][(int)op1[2].charAt(0)%97]=1;
			}
			else if(op1[0].equals("ontable"))
			{
				ontable[(int)op1[1].charAt(0)%97]=1;
			}
			else if(op1[0].equals("clear"))
			{
				clear[(int)op1[1].charAt(0)%97]=1;
			}
			else if(op1[0].equals("hold"))
			{
				hold[(int)op1[1].charAt(0)%97]=1;
			}
			else if(op1[0].equals("AE"))
			{
				arm=1;
			}
		}
	}
	
	void performaction(String[] split_pop_element)
	{
		if(split_pop_element[0].equals("stack"))//done
		{
			on[(int)split_pop_element[1].charAt(0)%97][(int)split_pop_element[2].charAt(0)%97]=1;
			clear[(int)split_pop_element[1].charAt(0)%97]=1;
			clear[(int)split_pop_element[2].charAt(0)%97]=0;
			hold[(int)split_pop_element[1].charAt(0)%97]=0;
			arm=1;
		}
		else if(split_pop_element[0].equals("unstack"))//done
		{
			on[(int)split_pop_element[1].charAt(0)%97][(int)split_pop_element[2].charAt(0)%97]=0;
			clear[(int)split_pop_element[1].charAt(0)%97]=0;
			clear[(int)split_pop_element[2].charAt(0)%97]=1;
			hold[(int)split_pop_element[1].charAt(0)%97]=1;
			arm=0;
		}
		else if(split_pop_element[0].equals("putdown"))//done
		{
			ontable[(int)split_pop_element[1].charAt(0)%97]=1;
			clear[(int)split_pop_element[1].charAt(0)%97]=1;
			hold[(int)split_pop_element[1].charAt(0)%97]=0;
			arm=1;
		}
		else if(split_pop_element[0].equals("pickup"))//done
		{
			hold[(int)split_pop_element[1].charAt(0)%97]=1;
			clear[(int)split_pop_element[1].charAt(0)%97]=0;
			ontable[(int)split_pop_element[1].charAt(0)%97]=0;
			arm=0;
		}
	}
		
	void printmatrix()
	{
		System.out.println("ON Matrix");
		for(int i=0;i<blocks;i++)
		{
			for(int j=0;j<blocks;j++)
			{
				System.out.print(on[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Ontable");
		for(int i=0;i<blocks;i++)
		{
			System.out.print(ontable[i]+" ");
		}
		System.out.println();
		System.out.println("clear");
		for(int i=0;i<blocks;i++)
		{
			System.out.print(clear[i]+" ");
		}
		System.out.println();
		System.out.println("hold");
		for(int i=0;i<blocks;i++)
		{
			System.out.print(hold[i]+" ");
		}
		System.out.println();
	}
	
}
