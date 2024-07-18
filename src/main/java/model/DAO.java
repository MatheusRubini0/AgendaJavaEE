package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Matheus@1";

	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Crud Create

	public void inserircontato(JavaBeans contato) {
		String create = "insert into contatos (nome, telefone, email) values (?,?,?)";

		try {
			// abrir a conexao
			Connection con = conectar();
			// preparar a query para execução no bd
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os paramentor da variavel create
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());
			// execução da query
			pst.executeUpdate();
			// encerrar conexão com o bd
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Crud Read

	public ArrayList<JavaBeans> listarContatos() {
		String read = "select * from contatos order by nome";
		ArrayList<JavaBeans> contatos = new ArrayList<>();

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);

				contatos.add(new JavaBeans(idcon, nome, telefone, email));
			}
			con.close();
			return contatos;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Crud Update
	public void selecionarContato(JavaBeans contato) {
		String Read2 = "select * from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(Read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setTelefone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set nome = {}, telefone = {} , email = {}  where idcon= {} ;"
				.formatted(contato.getNome(), contato.getTelefone(), contato.getEmail(), contato.getIdcon());
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			System.out.println("atualizado");
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e);
		}
	}

	public void deletarContato(JavaBeans contato) {
		String deletar = "delete from contatos where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(deletar);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
			System.out.println(con.prepareStatement(deletar));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
