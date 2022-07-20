package com.busy.apis.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{
	/*
	@Autowired
	private CorretorRepository corretorRepository;
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@Autowired 
	private RegiaoRepository regiaoRepository;
	
	@Autowired 
	private CaracteristicasImovelRepository caracteristicasImovelRepository;
	
	@Autowired 
	private CaracteristicasCondominioRepository caracteristicasCondominioRepository;
	
	@Autowired 
	private MotoristaRepository anuncioRepository;
	
	@Autowired 
	private LoginRepository loginRepository;
	*/
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
/*
		Regiao r1 = new Regiao(null, "BRASILIA", "ASA NORTE", "Quadra 500 a 510");
		Regiao r2 = new Regiao(null, "BRASILIA", "ASA NORTE", "Quadra 600 a 610");
		Regiao r3 = new Regiao(null, "BRASILIA", "ASA NORTE", "Quadra 700 a 710");
		Regiao r4 = new Regiao(null, "BRASILIA", "ASA SUL", "Quadra 500 a 510");
		Regiao r5 = new Regiao(null, "BRASILIA", "ASA SUL", "Quadra 600 a 610");
		
		regiaoRepository.save(r1);
		regiaoRepository.save(r2);
		regiaoRepository.save(r3);
		regiaoRepository.save(r4);
		regiaoRepository.save(r5);
	
		CaracteristicasImovel c1 = new CaracteristicasImovel (null, "Piscina");
		CaracteristicasImovel c2 = new CaracteristicasImovel (null, "Sauna");
		CaracteristicasImovel c3 = new CaracteristicasImovel (null, "Agua Aquecida");
		CaracteristicasImovel c4 = new CaracteristicasImovel (null, "PlayGround");
		CaracteristicasImovel c5 = new CaracteristicasImovel (null, "Jardim");
		
		caracteristicasImovelRepository.save(c1);
		caracteristicasImovelRepository.save(c2);
		caracteristicasImovelRepository.save(c3);
		caracteristicasImovelRepository.save(c4);
		caracteristicasImovelRepository.save(c5);
		
		CaracteristicasCondominio cc1 = new CaracteristicasCondominio (null, "Porteiro 24h");
		CaracteristicasCondominio cc2 = new CaracteristicasCondominio (null, "Piscina Olimpica");
		CaracteristicasCondominio cc3 = new CaracteristicasCondominio (null, "Onibus");
		CaracteristicasCondominio cc4 = new CaracteristicasCondominio (null, "Alarme e Segurança");
		CaracteristicasCondominio cc5 = new CaracteristicasCondominio (null, "Sistema Local de Irrigação");
		
		caracteristicasCondominioRepository.save(cc1);
		caracteristicasCondominioRepository.save(cc2);
		caracteristicasCondominioRepository.save(cc3);
		caracteristicasCondominioRepository.save(cc4);
		caracteristicasCondominioRepository.save(cc5);
		
		
	*/
    	

    	//Corretor ccc1 = new Corretor(Long.parseLong("46956172852"), "senha","senha", "Marta Tacioli", "23654125", "12982529766", "martatacioli1@gmail.com", "Rua Ibiuna");
    	//corretorRepository.save(ccc1);
    	
    //	Login lcc1 = new Login ("1234", ccc1);
    	//loginRepository.save(lcc1);
    	
    	
		//Corretor ccc2 = new Corretor(Long.parseLong("99999999999"),"senhaaa","Maria Juliana", "649845916", "1245684218", "mariajuliana@gmail.com", "Avenida Pedreiros");
		//corretorRepository.save(ccc2);

    //	Login lcc2 = new Login (Long.parseLong("999999999"), "1234", ccc2);
    	//loginRepository.save(lcc2);
    	
    	
		//Proprietario p1 = new Proprietario(Long.parseLong("1111111111"), "Lucas Neto", "1295872664", "lucasneto@gamil.com", "endereco", ccc1);
	//	proprietarioRepository.save(p1);
	//	Proprietario p2 = new Proprietario(Long.parseLong("2222222222"), "Lucas Junior", "1295872664", "lucasjunior@gamil.com", "endereco2", ccc1);
	//	proprietarioRepository.save(p2);
		
		//Anuncio a1 = new Anuncio ("Cobertura na Asa Norte", TipoImovel.APARTAMENTO,2, 2, 2,
		//		223,22, 223,"Lindo imovel blablablablablalbal",500, 1000,
		//		50000,r1,p1);
	
		
		
			
		//regiaoRepository.save(r1);
		

		
		
	}


}
