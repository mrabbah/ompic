# SPRING MVC REST API
## Actuator

1. Créez un projet nommé `restdemo` avec le starter web et avec devtools:
	![](images/1.png)
	![](images/2.png)

2. Ajoutez un package nommé `controllers`, et dans ce package créer la class `MyController`:
3. Annoter la class avec `@RestController` et créer une methode comme suite:

	```java
	@RestController
	public class MyController {
	
		@RequestMapping("/hello")
		@ResponseBody String hello() {
			return "test";
		}
	}

	```

3. Exécuter le projet et accéder à l'URL: [http://localhost:8080/hello](http://localhost:8080/hello)

	

4. changez l'annotation `@RequestMapping("/hello")` par `@RequestMapping(value = "/hello", method = RequestMethod.GET)`, qu'est ce que vous remarquez?
5. Ajoutez la fonction suivante:

	```java
	@GetMapping("/api/foos")
	@ResponseBody String getFoos() {
		return "Foos";
	}
	```
	
6. visitez l'URL: [http://localhost:8080/api/foos](http://localhost:8080/api/foos)

7. Ajoutez le package `dto ` et ajoutr les class `Personne` et `Party` suivante:

	```java
	package ma.ompic.restdemo.dto;
	
	public class Personne {
		private String nom;
		private String prenom;
		
		public Personne(String nom, String prenom) {
			this.nom = nom;
			this.prenom = prenom;
		}
	
		public String getNom() {
			return nom;
		}
	
		public void setNom(String nom) {
			this.nom = nom;
		}
	
		public String getPrenom() {
			return prenom;
		}
	
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
		
	}

	```
	```java
	package ma.ompic.restdemo.dto;
	
	import java.util.Date;
	import java.util.List;
	
	public class Party {
	
		private Date date;
		private String titre;
		private List<Personne> invites;	
		
		public Party(Date date, String titre, List<Personne> invites) {
			super();
			this.date = date;
			this.titre = titre;
			this.invites = invites;
		}
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public List<Personne> getInvites() {
			return invites;
		}
		public void setInvites(List<Personne> invites) {
			this.invites = invites;
		}
		
		
	}

	```
	
	
8. Au niveau de `MyController` ajouter la fonction suivante:

	```java
	@GetMapping("/api/personne/list")
	@ResponseBody List<Personne> listPersonnes() {
		List<Personne> personnes = new ArrayList<Personne>();
		personnes.add(new Personne("RABBAH", "Mahmoud"));
		personnes.add(new Personne("Ahmad", "Nabib"));
		return personnes;
	}
	```
	

9. Accéder à [http://localhost:8080/api/personne/list](http://localhost:8080/api/personne/list).
	![](images/3.png)
10. Ouvrez l'application Postman et cliquez sur **Create a request**
	![](images/4.png)
11. Entrez l'URL de la request pour lister les personnes et cliquez sur **Send**
	![](images/5.png)
12. Au lieu de commencer chaque Request Mapping par `/api` nous allons ajouter `server.servlet.context-path=/api` au niveau du fichier application properties et enlever des Request Mapping cette valeur.
13. Retester vos EndPoint
14. Ajouter la fonction suivante au nvieau de votre controller:

	```java
	@GetMapping("/personne/{id}")
	@ResponseBody Personne getPersonne(@PathVariable("id") int id) {
		return new Personne(id, "RABBAH", "Mahmoud");
	}
	```
	
15. Testez avec Postman:
	![](images/6.png)

16. Ajoutez la fonction suivante:

	```java
	@GetMapping("/personne")
	@ResponseBody Personne getPersonne(@RequestParam("id") int id, @RequestParam("nom") String nom) {
		return new Personne(id, nom, "YYYY");
	}
	```

17. Testez avec Postman:
	![](images/7.png) 
	
18. Ajoutez la fonction suivante:

	```java
	@PostMapping("/personne/add")
	@ResponseBody Personne addPersonne(@RequestBody Personne personne) {
		return new Personne(19, personne.getNom(), personne.getPrenom());
	}
	```
19. Testez avec Postman
	![](images/8.png)
	
## SPRING DATA REST
Dans cette partie nous allons voir un starter SPRING puissant `spring-boot-starter-data-rest`

**Nous allons continuer le développement sur le projet de l'atelier 3 pour les étapes qui suivent**

1. Au niveau du projet ajouter la dépendance suivante:

	```
	<dependency>
	    <groupId>org.springframework.boot</groupId
	    <artifactId>spring-boot-starter-data-rest</artifactId></dependency>
	<dependency>
	```
	
2. Créer l'interface suivante au niveau du package entities:

	```java
	@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
	public interface MyCustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	    List<Customer> findByLastName(@Param("lastName") String lastName);
	}
	```

3. Analysez les liens suviants:

	```
	http://localhost:9090/customers{?page,size,sort}
	
	http://localhost:9090/profile
	
	http://localhost:9090/customers
	
	http://localhost:9090/customers/1
	
	http://localhost:8080/customer/search/findByLastName?lastName=test
	```
	
## Exemple d'une table de la BdD OMPIC PROJET X

Essayer de créer un projet qui pointe sur une base de donnée de votre organisme, et exposer une EndPoint REST d'une table de la base de donnée

Elements qui peuvent aider

```
<dependency>
    <groupId>com.oracle</groupId>
    <artifactId>ojdbc7</artifactId>
    <version>12.1.0</version>
</dependency>
```

```
spring.jpa.hibernate.ddl-auto=validate #none, create, create-drop, validate, and update
spring.jpa.database-platform=org.hibernate.dialect.Oracle10gDialect
spring.datasource.url= jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=system
spring.datasource.password=changeme
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.jpa.show-sql=true
```
	
## REST TEMPLATE

Dans cette partie nous allons voir comment depuis votre application SPRING BOOT faire appel à une ENDPOINT REST.

1. Ajouter le code suivant à votre controller:

	```java
		@Bean
		public RestTemplate restTemplate() {
		    return new RestTemplate();
		}
	```	

	```java
		@Autowired
		RestTemplate rt;
		
		private final String url = "https://gturnquist-quoters.cfapps.io/api/random";
		
		
		@RequestMapping("/testresttemplate")
		@ResponseBody String testresttemplate() {
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	        return rt.exchange(this.url, HttpMethod.GET, entity, String.class).getBody();
		}
	```

2. Accéder à l'URL[ http://localhost:8080/testresttemplate]( http://localhost:8080/testresttemplate) pour voir le résultat

3. Casting de l'objet: créer la class suivante:

	```java
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Quote {
	
	    private String type;
	    private Value value;
	
	    public Quote() {
	    }
	
	    public String getType() {
	        return type;
	    }
	
	    public void setType(String type) {
	        this.type = type;
	    }
	
	    public Value getValue() {
	        return value;
	    }
	
	    public void setValue(Value value) {
	        this.value = value;
	    }
	
	    @Override
	    public String toString() {
	        return "Quote{" +
	                "type='" + type + '\'' +
	                ", value=" + value +
	                '}';
	    }
	}
	```
	
	```java
	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Value {
	
	    private Long id;
	    private String quote;
	
	    public Value() {
	    }
	
	    public Long getId() {
	        return this.id;
	    }
	
	    public String getQuote() {
	        return this.quote;
	    }
	
	    public void setId(Long id) {
	        this.id = id;
	    }
	
	    public void setQuote(String quote) {
	        this.quote = quote;
	    }
	
	    @Override
	    public String toString() {
	        return "Value{" +
	                "id=" + id +
	                ", quote='" + quote + '\'' +
	                '}';
	    }
	}
	```
	```java
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
	}
	```
	
	```java
	Quote quote = restTemplate.getForObject(
					this.url, Quote.class);
	log.info(quote.toString());
	```
	
## Attachement

Dans cette partie nous allons voir comment upload ou download un fichier en utilisant REST.

1. Créer un projet SPRING BOOT nommé: restattachement avec le starter Web et Devtools.
2. Premièrement configurant l'application de tel sorte à permettre le Multipart file uploads, et définir la taille maximale du fichier accepté: au niveau du fichier properties ajouter les lignes suivantes:

	```
	spring.servlet.multipart.enabled=true
	spring.servlet.multipart.file-size-threshold=2KB
	spring.servlet.multipart.max-file-size=200MB
	spring.servlet.multipart.max-request-size=215MB
	file.upload-dir=/tmp
	```	

**Notez qu'il faut changer le dossier à une chemin qui vous convient**

3. //TODO
	
	
	