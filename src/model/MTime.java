package model;

import java.time.LocalTime;

public class MTime {
	private String[] days;
	private LocalTime[] starts;
	private LocalTime[] ends;

	public MTime() {
	}

	public MTime(String time) {
		this.starts = new LocalTime[2];
		this.ends = new LocalTime[2];
		this.days = new String[2];

		String str = MTime.getNormalizedTime(time);
		this.days[0] = str.substring(0, 1);
		this.days[1] = str.substring(1, 2);
		this.starts[0] = this.starts[1] = LocalTime.of(
				Integer.parseInt(str.substring(2, 4)), Integer.parseInt(str.substring(4, 6)), 0);
		this.ends[0] = this.ends[1] = LocalTime.of(
				Integer.parseInt(str.substring(7, 9)), Integer.parseInt(str.substring(9, 11)), 0);

		if (str.contains(",")) {
			this.starts[1] =LocalTime.of(
					Integer.parseInt(str.substring(12, 14)), Integer.parseInt(str.substring(14, 16)), 0);
			this.ends[1] = LocalTime.of(Integer.parseInt(str.substring(17, 19)), Integer.parseInt(str.substring(19, 21)), 0);
		}
	}

	public boolean checkOverlap(MTime other) {
		for(int thisDay = 0; thisDay < 2; thisDay++) {
			for(int otherDay = 0; otherDay < 2; otherDay++) {
				if(this.starts[thisDay].isBefore(other.getStarts()[otherDay]) ||
						this.starts[thisDay].equals(other.getStarts()[otherDay])) {
					if(this.ends[thisDay].isAfter(other.getStarts()[otherDay])) {
						if(this.days[thisDay].equals(other.getDays()[otherDay])) {
							return true;
						}
					}
				}
				if(this.starts[thisDay].isBefore(other.getEnds()[otherDay]) ||
						this.starts[thisDay].equals(other.getEnds()[otherDay])) {
					if(this.ends[thisDay].isAfter(other.getEnds()[otherDay])) {
						if(this.days[thisDay].equals(other.getDays()[otherDay])) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}


	public static String getNormalizedTime(String time) {
		time = time.replace(":", "");
		time = time.replace("~", "-");
		String ret = "";
		if (time.contains(",")) {
			String[] times = time.split(",");
			String day1 = times[0].substring(0, 1);
			String day2 = times[0].substring(1, 2);
			String time1 = times[0].substring(2);
			String time2 = times[1].substring(0);
			if (time1.equals(time2)) {
				ret = day1 + day2 + time1;
			} else {
				ret = day1 + day2 + time1 + "," + time2;
			}
		} else {
			if (time.length() == 10) {
				ret = time.substring(0, 1) + time;
			} else if (time.length() == 9) {
				ret = "__" + time;
			} else {
				ret = time;
			}
		}
		
		if(ret.length() > 20) {
			if(ret.substring(1,10).equals(ret.substring(12))) {
				ret = ret.substring(0,1) + ret.substring(11,12) + ret.substring(1,10);
			}
		}
		return ret;
	}

	public String[] getDays() {
		return days;
	}

	public void setDays(String[] days) {
		this.days = days;
	}

	public LocalTime[] getStarts() {
		return starts;
	}

	public void setStarts(LocalTime[] starts) {
		this.starts = starts;
	}

	public LocalTime[] getEnds() {
		return ends;
	}

	public void setEnds(LocalTime[] ends) {
		this.ends = ends;
	}

	

}
