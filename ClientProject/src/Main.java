import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.pfa.election.dao.interfaces.CitoyenDaoRemote;
import tn.esprit.pfa.election.dao.interfaces.EmplacementDaoRemote;
import tn.esprit.pfa.election.dao.interfaces.PartisDaoRemote;
import tn.esprit.pfa.election.persistence.Citoyen;
import tn.esprit.pfa.election.persistence.Emplacement;
import tn.esprit.pfa.election.persistence.Partis;

public class Main {
	public static void main(String[] args) {

		Context ctx;
		try {
			ctx = new InitialContext();
			CitoyenDaoRemote ciRemote = (CitoyenDaoRemote) ctx
					.lookup("MangementOfThePresidentialElectionEAR/CitoyenDao/remote");

			PartisDaoRemote parRemote = (PartisDaoRemote) ctx
					.lookup("MangementOfThePresidentialElectionEAR/PartisDao/remote");

			EmplacementDaoRemote eRemote = (EmplacementDaoRemote) ctx
					.lookup("MangementOfThePresidentialElectionEAR/EmplacementDao/remote");

			List<Partis> partis = parRemote.findall();
			for (Partis p : partis) {
				System.out.println(p.getNom());

			}

			Citoyen citoyen0 = new Citoyen("daly", "bettaieb");
			Citoyen citoyen1 = new Citoyen("tahani", "masmoudi");
			Citoyen citoyen2 = new Citoyen("foulen", "ben foulen");
			Citoyen citoyen3 = new Citoyen("sala7", "ben amor");
			Citoyen citoyen4 = new Citoyen("fergani", "tounsi");

			Partis partis0 = new Partis("pdp");
			Partis partis1 = new Partis("ennahdha");
			Partis partis2 = new Partis("takattol");
			Partis partis3 = new Partis("efak");
			Partis partis4 = new Partis("maraa dimoncratique");

			Emplacement emplacement0 = new Emplacement("tunis");
			Emplacement emplacement1 = new Emplacement("sfax");
			Emplacement emplacement2 = new Emplacement("djerba");
			Emplacement emplacement3 = new Emplacement("beja");
			Emplacement emplacement4 = new Emplacement("kirouan");

			ciRemote.add(citoyen0);
			ciRemote.add(citoyen1);
			ciRemote.add(citoyen2);
			ciRemote.add(citoyen3);
			ciRemote.add(citoyen4);

			parRemote.add(partis0);
			parRemote.add(partis1);
			parRemote.add(partis2);
			parRemote.add(partis3);
			parRemote.add(partis4);

			eRemote.add(emplacement0);
			eRemote.add(emplacement1);
			eRemote.add(emplacement2);
			eRemote.add(emplacement3);
			eRemote.add(emplacement4);

			System.out.println("sibon");

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}