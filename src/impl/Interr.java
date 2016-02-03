package impl;

import java.sql.ResultSet;

import beann.Beann;

public interface Interr {
	public ResultSet login(Beann bean);
	public int register(Beann bean);
	public int stafflogin(Beann bean);
	public int update(Beann bean);

}
