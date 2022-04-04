package gpp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import gpp.model.github.api.caller.GitHubAPICaller;

public class GPPGitHubAPICallerTest {

	public static void main(String[] args) {

		ArrayList<String> emails = new ArrayList<String>();

		emails.add("aitormeleropicon@gmail.com");

		// System.out.println(GitHubAPICaller.createARepository("Repositorio_prueba",
		// "Repositorio de prueba usando API", true));

		//System.out.println(GitHubAPICaller.addAnEmailAddress(emails));

		// System.out.println(GitHubAPICaller.listEmailAddresses(0, 0));
		
		// CLONAR Y BORRAR REPOSITORIOS EN LOCAL
		
		//String cloneDirectoryPath = "src/main/resources/repositories/GitHub_Parser_Project/";
		
		//cloneRepository("AitorMelero", "Curso-React", cloneDirectoryPath);
		
		//deleteLocalRepository(cloneDirectoryPath);
		
		//deleteDirectoryStream(Paths.get(cloneDirectoryPath));;

	}

	public static void cloneRepository(String owner, String name, String cloneDirectoryPath) {

		String repoUrl = "https://github.com/" + owner + "/" + name + ".git";
		
		CredentialsProvider cp = new UsernamePasswordCredentialsProvider("AitorMelero", GitHubAPICaller.USER_TOKEN);
		
		try {
			
			System.out.println("Cloning " + repoUrl + " into " + repoUrl);
			Git.cloneRepository().setCredentialsProvider(cp).setURI(repoUrl).setDirectory(Paths.get(cloneDirectoryPath).toFile()).call();
			System.out.println("Completed Cloning");
			
		} catch (GitAPIException e) {
			
			System.out.println("Exception occurred while cloning repo");
			e.printStackTrace();
			
		}

	}
	
	public static void deleteLocalRepository(String repoPath) {
		
		//File localRepoFolder = Paths.get(repoPath).toFile();
		
		//localRepoFolder.delete();
		
		//FileUtils fileUtil = new FileUtils();
		
		try {
			Files.delete(Paths.get(repoPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			fileUtil.delete(localRepoFolder);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		/*try {
			Git gitRepo = Git.open(localRepoFolder);
			System.out.println("ENTRA AQUI");
			gitRepo.getRepository().close();
			System.out.println("ENTRA AQUI");
			gitRepo.close();
			System.out.println("ENTRA AQUI");
			localRepoFolder.deleteOnExit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR " + e.getMessage());
		}*/
		
	}
	
	public static void deleteDirectoryStream(Path path) {
		  try {
			Files.walk(path)
			    .sorted(Comparator.reverseOrder())
			    .map(Path::toFile)
			    .forEach(File::delete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
