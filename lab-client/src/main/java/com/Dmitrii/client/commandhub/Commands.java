package com.Dmitrii.client.commandhub;

public enum Commands {

	HELP("help", Help.class),//+
	INFO("info", Info.class),//+
	SHOW("show", Show.class),//+
	INSERT("insert", Insert.class),//+
	UPDATE_ID("update", UpdateId.class),//+
	REMOVE_KEY("remove_key", RemoveId.class),//+
	CLEAR("clear", Clear.class),//+
	SAVE("save", Save.class),//+
	EXECUTE_SCRIPT("execute_script", ExecuteScript.class),
	EXIT("exit", Exit.class),//+
	REMOVE_LOWER("remove_lower", RemoveLower.class),//+
	REPLACE_IF_GREATER("replace_if_greater", ReplaceIfGreater.class),
	REMOVE_LOWER_KEY("remove_lower_key", RemoveLowerKey.class),
	MAX_BY_SALARY("max_by_salary", MaxBySalary.class),//+
	PRINT_ASCENDING("print_ascending", PrintAscending.class),//+
	PRINT_UNIQUE_POSITION("print_unique_position", PrintUniquePosition.class);//+

	private String commandName;
	private Class commandClass;

	Commands(String comName, Class comClass) {
		this.commandName = comName;
		this.commandClass = comClass;
	}

	public String getCommandName() {
		return commandName;
	}

	public Class getCommandClass() {
		return commandClass;
	}
}
