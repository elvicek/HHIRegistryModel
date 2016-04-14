package com.aes.model;
// Generated Apr 14, 2016 4:36:50 PM by Hibernate Tools 3.5.0.Final



/**
 * SurveyClientId generated by hbm2java
 */
public class SurveyClientId  implements java.io.Serializable {


     private int surveyId;
     private int clientId;

    public SurveyClientId() {
    }

    public SurveyClientId(int surveyId, int clientId) {
       this.surveyId = surveyId;
       this.clientId = clientId;
    }
   
    public int getSurveyId() {
        return this.surveyId;
    }
    
    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }
    public int getClientId() {
        return this.clientId;
    }
    
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SurveyClientId) ) return false;
		 SurveyClientId castOther = ( SurveyClientId ) other; 
         
		 return (this.getSurveyId()==castOther.getSurveyId())
 && (this.getClientId()==castOther.getClientId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSurveyId();
         result = 37 * result + this.getClientId();
         return result;
   }   


}

