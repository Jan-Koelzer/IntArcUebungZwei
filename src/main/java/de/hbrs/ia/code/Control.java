package de.hbrs.ia.code;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialPerfomanceRecord;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Control implements ManagePersonal{

    MongoCollection<Document> salesmen;
    MongoCollection<Document> socialperfomance;

    public Control(MongoCollection<Document> socialperfomance, MongoCollection<Document> salesmen) {
        this.socialperfomance = socialperfomance;
        this.salesmen = salesmen;
    }

    @Override
    public void createSalesMan(SalesMan record) {
        Document salesman = new Document();
        salesman.append("sid", record.getId());
        salesman.append("firstname", record.getFirstname());
        salesman.append("lastname", record.getLastname());
        salesmen.insertOne(salesman);
    }

    @Override
    public void addSocialPerformanceRecord(SocialPerfomanceRecord record, SalesMan salesMan) {
        record.setSalesmanId(salesMan.getId());
        socialperfomance.insertOne(record.toDocument());
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        Document salesmanDoc = salesmen.find(new Document("sid", sid)).first();
        if (salesmanDoc != null) {
            return SalesMan.documentToSalesMan(salesmanDoc);
        }
        return null;
    }

    @Override
    public List<SalesMan> readAllSalesMen() {
        FindIterable<Document> allSalesmen = salesmen.find();
        List<SalesMan> salesmenList = new ArrayList<>();
        for (Document salesmanDoc : allSalesmen) {
            salesmenList.add(SalesMan.documentToSalesMan(salesmanDoc));
        }
        return salesmenList;
    }

    @Override
    public List<SocialPerfomanceRecord> readSocialPerformanceRecord(SalesMan salesMan) {
        FindIterable<Document> socialPerfomanceRecordsDocs = socialperfomance.find(new Document("salesmanId",salesMan.getId()));
        List<SocialPerfomanceRecord> socialPerfomanceRecords = new ArrayList<>();
        for (Document socialPerfomanceRecord : socialPerfomanceRecordsDocs) {
            socialPerfomanceRecords.add(SocialPerfomanceRecord.documentToSocialPerfomanceRecord(socialPerfomanceRecord));
        }
        return socialPerfomanceRecords;
    }







}
