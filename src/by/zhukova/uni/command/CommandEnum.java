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
	},
	REGISTER {
		{
			this.command = new RegisterCommand();
		}
	},
	CHFAC {
		{
			this.command = new ChooseFacultyCommand();
		}
	},
	ADDSCORES {{
		 this.command = new AddScoresCommand();
		
	}},
	
	APPLIC {{
		this.command = new ApplicationActionCommand();
	}},
	FAC {{
		this.command = new FacultiesCommand();
	}},
	SHOWFAC {{
		this.command = new ShowFacultyCommand();
	}};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}