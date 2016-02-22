package dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import constants.Const;

public class MongoConnector {
	private MongoClient mongo = null;
	private static DB db = null;

	private static MongoConnector mgc = null;

	public static DB getInstance() {
		DB returnValue;
		if (mgc == null) {
			mgc = new MongoConnector();
			returnValue = db;
		} else {
			returnValue = db;
		}
		return returnValue;
	}

	private MongoConnector() {

		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB(Const.DB_NAME);
	}

}
