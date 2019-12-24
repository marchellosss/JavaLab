public class Turnstile {
     private boolean access = false;
     private int currentDay;
     private int currentMonth;
     private String[] generalHistory = new String[10];
     private String[] studentHistory = new String[10];
     private String[] childHistory = new String[10];
     private String[] usualHistory = new String[10];
     private int generalCount = 0;
     private int studentCount = 0;
     private int childCount = 0;
     private int usualCount = 0;

     public Turnstile( int currentDay, int currentMonth) {
         this.currentDay = currentDay;
         this.currentMonth = currentMonth;
     }

     public boolean checkAccess(StudentPass pass) {
         if( checkValidity(pass)) {
             checkTripsNumber(pass);

             if (this.access) {
                 generalHistory[this.generalCount] = "Allowed";
                 this.generalCount++;
                 studentHistory[this.studentCount] = "Allowed";
                 this.studentCount++;
             } else {
                 generalHistory[this.generalCount] = "Denied";
                 this.generalCount++;
                 studentHistory[this.studentCount] = "Denied";
                 this.studentCount++;
             }
             return this.access;
         }
         else
         {
             generalHistory[this.generalCount] = "Denied";
             this.generalCount++;
             studentHistory[this.studentCount] = "Denied";
             this.studentCount++;
         }
         return this.access;
     }

     public boolean checkAccess(ChildPass pass) {
         if( checkValidity(pass)) {
             checkTripsNumber(pass);

             if (this.access) {
                 generalHistory[this.generalCount] = "Allowed";
                 this.generalCount++;
                 childHistory[this.childCount] = "Allowed";
                 this.childCount++;
             } else {
                 generalHistory[this.generalCount] = "Denied";
                 this.generalCount++;
                 childHistory[this.childCount] = "Denied";
                 this.childCount++;
             }
             return this.access;
         }
         else
         {
             generalHistory[this.generalCount] = "Denied";
             this.generalCount++;
             childHistory[this.childCount] = "Denied";
             this.childCount++;
         }
         return this.access;
     }

     public boolean checkAccess(UsualPass pass) {

         if( checkValidity(pass)) {
             checkTripsNumber(pass);

             if (this.access) {
                 generalHistory[this.generalCount] = "Allowed";
                 this.generalCount++;
                 usualHistory[this.usualCount] = "Allowed";
                 this.usualCount++;
             } else {
                 generalHistory[this.generalCount] = "Denied";
                 this.generalCount++;
                 usualHistory[this.usualCount] = "Denied";
                 this.usualCount++;
             }
             return this.access;
         }
         else
         {
             generalHistory[this.generalCount] = "Denied";
             this.generalCount++;
             usualHistory[this.usualCount] = "Denied";
             this.usualCount++;
         }
         return this.access;
     }

     private boolean checkValidity( Pass pass) {
         int remainderDays = 0;

         if( pass.getValidity() == 10) {
             int month = this.currentMonth - pass.getRegistrationMonth();

             if ( month==1) {
                 remainderDays = 10-( (30 - pass.getRegistrationDay()) + this.currentDay);
                 if( remainderDays > 0) {
                     this.access = true;
                 }
             }
             if(month==0) {

                 if (this.currentMonth == pass.getRegistrationMonth()) {
                     remainderDays = this.currentDay - pass.getRegistrationDay();

                     if (remainderDays <= 10) {
                         this.access = true;
                     }
                 }
             }
         }
         if( pass.getValidity() == 30) {
             int month = this.currentMonth - pass.getRegistrationMonth();

             if ( month==1) {
                 remainderDays = 31-( 30-pass.getRegistrationDay() + this.currentDay);

                 if( remainderDays > 0) {
                     this.access = true;
                 }
             }
             if(month==0) {

                 if (this.currentMonth == pass.getRegistrationMonth()) {
                     remainderDays = this.currentDay - pass.getRegistrationDay();

                     if (remainderDays <= 30) {
                         this.access = true;
                     }
                 }
             }
         }
         if(pass.getValidity() == 365)
         {
             this.access = true;
         }
         return this.access;
     }

     private void checkTripsNumber( Pass pass) {

         if( pass.getTripsNumber()>0){
             this.access =true;
         }
         else{
             this.access = false;
         }
     }

     public void showGeneralHistory()
     {
         for ( int i = 0; i <= this.generalCount-1; i++)
         {
             System.out.println(this.generalHistory[i]);
         }
         System.out.println();
     }

     public void showStudentHistory()
     {
         for ( int i = 0; i <= this.studentCount-1; i++)
         {
             System.out.println(this.studentHistory[i]);
         }
         System.out.println();
     }

     public void showChildHistory()
     {
         for ( int i = 0; i <= this.childCount-1; i++)
         {
             System.out.println(this.childHistory[i]);
         }
         System.out.println();
     }

     public void showUsualHistory()
     {
         for ( int i = 0; i <= this.usualCount-1; i++)
         {
             System.out.println(this.usualHistory[i]);
         }
         System.out.println();
     }
     public int  getCurrentDay()
     {
         return this.currentDay;
     }
    public int  getCurrentMonth()
    {
        return this.currentMonth;
    }
}
