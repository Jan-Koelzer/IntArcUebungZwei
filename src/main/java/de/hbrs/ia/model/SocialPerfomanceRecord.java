package de.hbrs.ia.model;

import org.bson.Document;

import java.util.HashMap;

public class SocialPerfomanceRecord {
    int sid;
    int salesmanId;
    int leadershipCompetence;
    int opennessToEmployee;
    int socialBehaviourToEmployee;
    int attidudeTowardsClient;
    int communicationSkills;
    int integrityToCompany;

    public SocialPerfomanceRecord(int sid, int salesmanId, int leadershipCompetence, int opennessToEmployee, int socialBehaviourToEmployee, int attidudeTowardsClient, int communicationSkills, int integrityToCompany) {
        this.sid = sid;
        this.salesmanId = salesmanId;
        this.leadershipCompetence = leadershipCompetence;
        this.opennessToEmployee = opennessToEmployee;
        this.socialBehaviourToEmployee = socialBehaviourToEmployee;
        this.attidudeTowardsClient = attidudeTowardsClient;
        this.communicationSkills = communicationSkills;
        this.integrityToCompany = integrityToCompany;
    }

    public SocialPerfomanceRecord(int sid, int leadershipCompetence, int opennessToEmployee, int socialBehaviourToEmployee, int attidudeTowardsClient, int communicationSkills, int integrityToCompany) {
        this.sid = sid;
        this.leadershipCompetence = leadershipCompetence;
        this.opennessToEmployee = opennessToEmployee;
        this.socialBehaviourToEmployee = socialBehaviourToEmployee;
        this.attidudeTowardsClient = attidudeTowardsClient;
        this.communicationSkills = communicationSkills;
        this.integrityToCompany = integrityToCompany;
    }

    public int getSid() {
        return sid;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    public int getSalesmanId() {
        return salesmanId;
    }

    public int getLeadershipCompetence() {
        return leadershipCompetence;
    }

    public int getOpennessToEmployee() {
        return opennessToEmployee;
    }

    public int getSocialBehaviourToEmployee() {
        return socialBehaviourToEmployee;
    }

    public int getAttidudeTowardsClient() {
        return attidudeTowardsClient;
    }

    public int getCommunicationSkills() {
        return communicationSkills;
    }

    public int getIntegrityToCompany() {
        return integrityToCompany;
    }

    public Document toDocument(){
        return new Document("sid", getSid())
                .append("salesmanId", getSalesmanId())
                .append("leadershipCompetence", getLeadershipCompetence())
                .append("opennessToEmployee", getOpennessToEmployee())
                .append("socialBehaviourToEmployee", getSocialBehaviourToEmployee())
                .append("attitudeTowardsClient", getAttidudeTowardsClient())
                .append("communicationSkills", getCommunicationSkills())
                .append("integrityToCompany", getIntegrityToCompany());
    }

    public static SocialPerfomanceRecord documentToSocialPerfomanceRecord(Document socialPerformanceDoc) {
        return new SocialPerfomanceRecord(
                socialPerformanceDoc.getInteger("sid"),
                socialPerformanceDoc.getInteger("salesmanId"),
                socialPerformanceDoc.getInteger("leadershipCompetence"),
                socialPerformanceDoc.getInteger("opennessToEmployee"),
                socialPerformanceDoc.getInteger("socialBehaviourToEmployee"),
                socialPerformanceDoc.getInteger("attitudeTowardsClient"),
                socialPerformanceDoc.getInteger("communicationSkills"),
                socialPerformanceDoc.getInteger("integrityToCompany")
        );
    }
}
