package com.banksystem.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banksystem.model.Account;
import com.banksystem.utility.DBConnection;

public class BankOperations implements BankDoc {
	DBConnection db = new DBConnection();
	Connection con = null;

	@Override
	public void createAccount(Account a) {
		PreparedStatement ps = null;
		try {
			con = db.getConnection();
			ps = con.prepareStatement("insert into account values (?,?,?,?)");
			ps.setInt(1, a.getAccno());
			ps.setString(2, a.getAccname());
			ps.setString(3, a.getPhone());
			ps.setDouble(4, a.getBalance());
			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println(n + " row(s) inserted");
			} else {
				System.out.println("Something went Wrong");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public void depositeMoneyById(int acno, Account a) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		try {
			con = db.getConnection();
			ps = con.prepareStatement("select accno from account where accno=?");
			ps.setInt(1, acno);
			rs = ps.executeQuery();
			int c = 0;
			while (rs.next()) {
				c++;
			}
			if (c > 0) {
				ps1 = con.prepareStatement("update account set balance=balance+? where accno=?");
				ps1.setDouble(1, a.getBalance());
				ps1.setInt(2, acno);
				int n = ps1.executeUpdate();
				if (n > 0) {
					System.out.println(n + "rows updated");
				} else {
					System.out.println("something went wrong");
				}
			} else {
				System.out.println(acno + " not found !!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps1 != null) {
					ps1.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e);
			}
		}

	}

	// @Override
	public void withdrawMoneyById(int acno, Account a) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		try {
			con = db.getConnection();
			ps = con.prepareStatement("select balance from account where accno=?");
			ps.setInt(1, acno);
			rs = ps.executeQuery();
			int c = 0;
			double bal = 0.0;
			while (rs.next()) {
				bal = rs.getDouble(1);
				c++;
			}
			if (c > 0 && bal >= a.getBalance()) {
				ps1 = con.prepareStatement("update account set balance=balance-? where accno=?");
				ps1.setDouble(1, a.getBalance());
				ps1.setInt(2, acno);
				int n = ps1.executeUpdate();
				if (n > 0) {
					System.out.println(n + "rows updated");
				} else {
					System.out.println("something went wrong");
				}
			} else {
				System.out.println(acno + " not found  or insufficient balance!!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps1 != null) {
					ps1.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public void checkBalance(int acno) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = db.getConnection();
			ps = con.prepareStatement("select balance from account where accno=?");
			ps.setInt(1, acno);
			rs = ps.executeQuery();
			int c = 0;
			double bal = 0.0;
			while (rs.next()) {
				bal = rs.getDouble(1);
				// System.out.print("Current Balance for "+acno+" is :"+rs.getDouble(1));
				c++;
			}
			if (c > 0) {
				System.out.println("Current Balance for " + acno + " is :" + bal);
			} else {
				System.out.println(acno + " not found!!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
	}

	@Override
	public boolean viewAccountDetailsById(int acno) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			con = db.getConnection();
			ps = con.prepareStatement("select * from account where accno=?");
			ps.setInt(1, acno);
			rs = ps.executeQuery();
			while (rs.next()) {
				flag = true;
				System.out.println(
						rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getDouble(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
		return flag;
	}

	@Override
	public void transferAmountByProcedure(int acno1, int acno2, double amt) {
		CallableStatement cs = null;
		try {
			con = db.getConnection();
			cs = con.prepareCall("{call new_procedure(?,?,?)}");
			cs.setInt(1, acno1);
			cs.setInt(2, acno2);
			cs.setDouble(3, amt);
			int n = cs.executeUpdate();
			if (n > 0) {
				System.out.println("Amount Successfully transfered from " + acno1 + " to " + acno2);
			} else {
				System.out.println("Something went Wrong");
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				if (cs != null) {
					cs.close();
				}
				if (con != null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
	}
}
