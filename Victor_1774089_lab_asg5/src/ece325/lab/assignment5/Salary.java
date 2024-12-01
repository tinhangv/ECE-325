package ece325.lab.assignment5;

public class Salary {
	
	/**
	 * Returns the amount of pay a band member will get (in dollars). This amount is
	 * computed by deducting the amount spent on snacks from the base salary, and
	 * then computing and adding the bonus (if any) over that amount. So, if a band
	 * member earned 100 dollars, spent 50 on snacks, and earned a bonus of 10 (%),
	 * their total pay will be 55 dollars.
	 * 
	 * Note: The current implementation of this method is extremely buggy and can
	 * easily be abused by anyone.
	 * 
	 * @param salary       The base salary earned by this band member during this
	 *                     salary period (in dollars).
	 * @param snacksAmount The total amount spent by this band member on snacks
	 *                     during this salary period (in dollars).
	 * @param bonus        The bonus percentage that the band member earned this
	 *                     salary period (in percentage).
	 * @return the amount of pay a band member will get (in dollars)
	 */
	public static Double pay(Double salary, Double snacksAmount, Integer bonus) {
		//validate inputs
		if(salary == null || snacksAmount==null || bonus == null)
			throw new IllegalArgumentException("null argument(s)");
		if(salary<0 || salary>1000)
			throw new IllegalArgumentException("invalid salary");
		if(bonus<0 || bonus>10)
			throw new IllegalArgumentException("invalid bonus");
		if(snacksAmount > salary || snacksAmount <0)
			throw new IllegalArgumentException("invalid snacksAmount");
		
		return (salary - snacksAmount) * (1+bonus/100d);
	}
}
