package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.app.companyfp_app.model.Student;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StudentRealmProxy extends Student
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_NAME;
    private static long INDEX_BIRTHDAY;
    private static long INDEX_EMAIL;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("birthday");
        fieldNames.add("email");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    @Override
    public String getId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_ID);
    }

    @Override
    public void setId(String value) {
        realm.checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field id to null.");
        }
        row.setString(INDEX_ID, (String) value);
    }

    @Override
    public String getName() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_NAME);
    }

    @Override
    public void setName(String value) {
        realm.checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field name to null.");
        }
        row.setString(INDEX_NAME, (String) value);
    }

    @Override
    public Date getBirthday() {
        realm.checkIfValid();
        return (java.util.Date) row.getDate(INDEX_BIRTHDAY);
    }

    @Override
    public void setBirthday(Date value) {
        realm.checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field birthday to null.");
        }
        row.setDate(INDEX_BIRTHDAY, (Date) value);
    }

    @Override
    public String getEmail() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_EMAIL);
    }

    @Override
    public void setEmail(String value) {
        realm.checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field email to null.");
        }
        row.setString(INDEX_EMAIL, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Student")) {
            Table table = transaction.getTable("class_Student");
            table.addColumn(ColumnType.STRING, "id", Table.NOT_NULLABLE);
            table.addColumn(ColumnType.STRING, "name", Table.NOT_NULLABLE);
            table.addColumn(ColumnType.DATE, "birthday", Table.NOT_NULLABLE);
            table.addColumn(ColumnType.STRING, "email", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_Student");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Student")) {
            Table table = transaction.getTable("class_Student");
            if (table.getColumnCount() != 4) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 4 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 4; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Student");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_BIRTHDAY = table.getColumnIndex("birthday");
            INDEX_EMAIL = table.getColumnIndex("email");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
            }
            if (table.isColumnNullable(INDEX_ID)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'id' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'id' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Primary key not defined for field 'id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (table.isColumnNullable(INDEX_NAME)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'name' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'name' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
            if (!columnTypes.containsKey("birthday")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'birthday' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("birthday") != ColumnType.DATE) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Date' for field 'birthday' in existing Realm file.");
            }
            if (table.isColumnNullable(INDEX_BIRTHDAY)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'birthday' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'birthday' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
            if (!columnTypes.containsKey("email")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("email") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'email' in existing Realm file.");
            }
            if (table.isColumnNullable(INDEX_EMAIL)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'email' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'email' or migrate using io.realm.internal.Table.convertColumnToNotNullable().");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Student class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Student";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Student createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Student obj = null;
        if (update) {
            Table table = realm.getTable(Student.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new StudentRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getUncheckedRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(Student.class);
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                obj.setId(null);
            } else {
                obj.setId((String) json.getString("id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                obj.setName(null);
            } else {
                obj.setName((String) json.getString("name"));
            }
        }
        if (json.has("birthday")) {
            if (json.isNull("birthday")) {
                obj.setBirthday(null);
            } else {
                Object timestamp = json.get("birthday");
                if (timestamp instanceof String) {
                    obj.setBirthday(JsonUtils.stringToDate((String) timestamp));
                } else {
                    obj.setBirthday(new Date(json.getLong("birthday")));
                }
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                obj.setEmail(null);
            } else {
                obj.setEmail((String) json.getString("email"));
            }
        }
        return obj;
    }

    public static Student createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Student obj = realm.createObject(Student.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setId(null);
                } else {
                    obj.setId((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setName(null);
                } else {
                    obj.setName((String) reader.nextString());
                }
            } else if (name.equals("birthday")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setBirthday(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        obj.setBirthday(new Date(timestamp));
                    }
                } else {
                    obj.setBirthday(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setEmail(null);
                } else {
                    obj.setEmail((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Student copyOrUpdate(Realm realm, Student object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        Student realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(Student.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (object.getId() == null) {
                throw new IllegalArgumentException("Primary key value must not be null.");
            }
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new StudentRealmProxy();
                realmObject.realm = realm;
                realmObject.row = table.getUncheckedRow(rowIndex);
                cache.put(object, (RealmObjectProxy) realmObject);
            } else {
                canUpdate = false;
            }
        }

        if (canUpdate) {
            return update(realm, realmObject, object, cache);
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static Student copy(Realm realm, Student newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Student realmObject = realm.createObject(Student.class, newObject.getId());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());
        realmObject.setName(newObject.getName());
        realmObject.setBirthday(newObject.getBirthday());
        realmObject.setEmail(newObject.getEmail());
        return realmObject;
    }

    static Student update(Realm realm, Student realmObject, Student newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setName(newObject.getName());
        realmObject.setBirthday(newObject.getBirthday());
        realmObject.setEmail(newObject.getEmail());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Student = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{birthday:");
        stringBuilder.append(getBirthday());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(getEmail());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRealmProxy aStudent = (StudentRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aStudent.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aStudent.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aStudent.row.getIndex()) return false;

        return true;
    }

}
