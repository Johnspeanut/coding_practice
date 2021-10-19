class CalculateDays {
  int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
  public int daysBetweenDates(String date1, String date2) {
    return Math.abs(dateSince1971(date1) - dateSince1971(date2));
  }

  private int dateSince1971(String date){
    String[] dates = date.split("-");
    int year = Integer.parseInt(dates[0]);
    int month = Integer.parseInt(dates[1]);
    int day = Integer.parseInt(dates[2]);
    int count = day;
    for(int i = 1971; i < year; i++){
      if(isLeapYear(i)){
        count+=366;
      }else{
        count+=365;
      }
    }
    for(int j = 0; j < month-1; j++){
      count+=months[j];
    }
    if(month > 2 && isLeapYear(year)){
      count+=1;
    }
    return count;

  }

  private boolean isLeapYear(int year){
    return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
  }
}