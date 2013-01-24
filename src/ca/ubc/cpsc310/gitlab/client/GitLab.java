package ca.ubc.cpsc310.gitlab.client;

import java.util.List;

import ca.ubc.cpsc310.gitlab.client.service.LoadUsersService;
			}

			@Override
			public void onSuccess(List<IUser> result) {
				Window.alert("Got list back with " +  result.size() + " entries");
				
		displayUsers(result);		
			}});
	}
	
	/**
	 * Used to display users 
	 * @param users
	 */
	public void displayUsers(List<IUser> users)
	{

		RootPanel.get("root").add(flexTable);
		
		flexTable.setText(0,0, "Name");
		
		flexTable.setText(0,1,"Language");
		flexTable.setText(0,2, "Shopping Cart Size");
		flexTable.setText(0,3, "Wish List Size");
		flexTable.setStyleName("centered-table", true);
		
		for(int i=0; i < users.size(); i++)
		{
		
			IUser user = users.get(i);
			
			flexTable.setText(i+1,0,user.getName());
			if(user.getLanguage().trim().equals("EN"))
			{
				flexTable.setWidget(i+1, 1, new Image("uk.png"));
			} else if (user.getLanguage().trim().equals("FR"))
			{
				flexTable.setWidget(i+1, 1, new Image("fr.png"));
			} else
			{
				flexTable.setText(i+1,1,user.getLanguage());
			}
			
			flexTable.setText(i+1,2,String.valueOf(user.getShoppingCart().size()));
			
			flexTable.setText(i+1,3,String.valueOf(user.getWishList().size()));
		}
	}
}
