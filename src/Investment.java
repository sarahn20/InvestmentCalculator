import java.util.ArrayList;

public class Investment 
{
	ArrayList<Contribution> theContributions;

	public Investment()
	{
		this.theContributions = new ArrayList<Contribution>();
	}

	void addContribution(Contribution c)
	{
		this.theContributions.add(c);
	}

	double getCurrentValue(int afterHowManyMonth)
	{
		//return the current value of this investment taking
		//time and an average 8% yearly or 0.67% monthly return
		//over afterHowManyMonths number of months
		int currMonth = 2;
		double currVal = 0;
		int i = 0;
		while(currMonth <= afterHowManyMonth) //accumulate interest for the correct number of months
		{
			if(i < this.theContributions.size()) //iterate through all elements of the given ArrayList
			{
				if(this.theContributions.get(i).monthNumber < currMonth) //check for new Contributions
				{
					currVal = currVal + this.theContributions.get(i).amount;
					i++;
				}
				currVal = currVal * 1.0067;
				currMonth = currMonth + 1;
			}
			else
			{
				currVal = currVal * 1.0067;
				currMonth = currMonth + 1;
			}
		}
		return currVal; 
	}
	double getTotalContributions()
	{
		//return the total amount ever investment not taking into
		//account interest.
		double totalCont = 0;
		for(int i = 0; i < this.theContributions.size(); i++)
		{
			totalCont = totalCont + this.theContributions.get(i).amount;
		}
		return totalCont;
	}	
}
