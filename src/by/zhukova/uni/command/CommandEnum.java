package by.zhukova.uni.command;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	LANG {
		{
			this.command = new LangCommand();
		}
	//},
	//ENLOCALE{
//		{
	//		this.command = new LocaleEnCommand();
	//	}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}