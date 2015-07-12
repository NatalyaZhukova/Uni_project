
package by.zhukova.uni.command;


/**
 * The Enum CommandEnum contains command names.
 */
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
	
	
	CREATEFAC {{
		this.command = new CreateFacultyCommand();
	}},
	
	
	SHOWFAC {{
		this.command = new ShowFacultyCommand();
	}},
	
	
	EDITFAC {{
		this.command = new EditFacultyCommand();
	}},
	
	
	DELFAC {{
		this.command = new DeleteFacultyCommand();
	}},
	
	
	ABITUR {{
		this.command = new ShowAbiturientsListCommand();
	}},
	
	
	SHOWABITUR {{
		this.command = new ShowAbiturientCommand();
	}},
	
	
	CHANGESTAT {{
		this.command = new ChangeStatusCommand();
	}};
	
	/** The command. */
	ActionCommand command;

	/**
	 * Gets the current command.
	 *
	 * @return the current command
	 */
	public ActionCommand getCurrentCommand() {
		return command;
	}
}