package synapticloop.sample.h2zero.mysql.model;

// - - - - thoughtfully generated by synapticloop h2zero - - - - 
//    with the use of synapticloop templar templating language
//                  (java-create-model.templar)

import java.util.HashMap;

import java.util.Map;


import org.json.JSONObject;

import synapticloop.h2zero.base.model.ModelBaseHelper;
import synapticloop.sample.h2zero.mysql.model.util.Constants;


public class UserType  {
	// the binder is unused in code, but will generate compile problems if this 
	// class is no longer referenced in the h2zero file. Just a nicety for
	// removing dead code
	@SuppressWarnings("unused")
	private static final String BINDER = Constants.USER_TYPE_BINDER;

	public static final UserType NORMAL = new UserType(Long.valueOf(1), "normal");
	public static final UserType SPECIAL = new UserType(Long.valueOf(2), "special");
	public static final UserType ADMIN = new UserType(Long.valueOf(3), "admin");
	public static final UserType SUPER_ADMIN = new UserType(Long.valueOf(4), "super admin");

	public static final UserType[] ALL =  {
		UserType.NORMAL, UserType.SPECIAL, UserType.ADMIN, UserType.SUPER_ADMIN
	};

	public static final Map<Long, UserType> ALL_LOOKUP = new HashMap<>();
	static{
		ALL_LOOKUP.put(Long.valueOf(1), UserType.NORMAL);
		ALL_LOOKUP.put(Long.valueOf(2), UserType.SPECIAL);
		ALL_LOOKUP.put(Long.valueOf(3), UserType.ADMIN);
		ALL_LOOKUP.put(Long.valueOf(4), UserType.SUPER_ADMIN);

	};

	public static final String PRIMARY_KEY_FIELD = "id_user_type";



	private Long idUserType = null;
	private String nmUserType = null;

	public UserType(Long idUserType, String nmUserType) {
		this.idUserType = idUserType;
		this.nmUserType = nmUserType;
	}
	/*
	 * Boring ol' getters and setters 
	 */

	public Long getPrimaryKey() { return(this.idUserType); }
	public Long getIdUserType() { return(this.idUserType); }
	public String getNmUserType() { return(this.nmUserType); }

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Model[UserType]\n");
		stringBuilder.append("  Field[idUserType:" + this.idUserType + "]\n");
		stringBuilder.append("  Field[nmUserType:" + this.nmUserType + "]\n");
		return(stringBuilder.toString());
	}
	public JSONObject getToJSON() {
		return(toJSON());
	}

	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("type", "UserType");

		ModelBaseHelper.addtoJSONObject(jsonObject, "idUserType", this.getIdUserType());
		ModelBaseHelper.addtoJSONObject(jsonObject, "nmUserType", this.getNmUserType());
		return(jsonObject);
	}


	public String toJsonString() {
		return(toJSON().toString());
	}

	public String getJsonString() {
		return(toJsonString());
	}
}