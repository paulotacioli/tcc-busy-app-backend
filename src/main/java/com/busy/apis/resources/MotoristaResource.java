/*
 * package com.busy.apis.resources;
 * 
 * import java.io.IOException; import java.net.URI; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 * 
 * import com.busy.apis.entities.Motorista; import
 * com.busy.apis.entities.matrix.RequestLoginMotorista; import
 * com.busy.apis.service.MotoristaService;
 * 
 * @RestController
 * 
 * @RequestMapping (value = "/motorista") public class MotoristaResource {
 * 
 * @Autowired private MotoristaService service;
 * 
 * @GetMapping public ResponseEntity<List<Motorista>> findAll(){ List<Motorista>
 * list = service.findAll(); return ResponseEntity.ok().body(list); }
 * 
 * @GetMapping(value = "/{id}") public ResponseEntity<Motorista>
 * findById(@PathVariable Long id){ Motorista obj = service.findById(id); return
 * ResponseEntity.ok().body(obj); }
 * 
 * @GetMapping(value = "/transportadora/{cnpj}") public
 * ResponseEntity<List<Motorista>> findAllByTransportadoraCnpj(@PathVariable
 * Long cnpj){ List<Motorista> list = service.findAllByTransportadoraCnpj(cnpj);
 * return ResponseEntity.ok().body(list); }
 * 
 * @GetMapping(value = "/transportadora/motoristas/pendentes/{cnpj}") public
 * ResponseEntity<List<Motorista>> encontrarMotoristasPendentes(@PathVariable
 * Long cnpj){ List<Motorista> list =
 * service.encontrarMotoristasPendentes(cnpj); return
 * ResponseEntity.ok().body(list); }
 * 
 * 
 * 
 * @PostMapping public ResponseEntity<Motorista> insert (@RequestBody Motorista
 * obj){
 * 
 * System.out.println(obj.toString()); obj = service.insert(obj); URI uri =
 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
 * .buildAndExpand(obj.getId()).toUri(); return
 * ResponseEntity.created(uri).body(obj); }
 * 
 * 
 * @PostMapping (value="/aprovar-motorista") public String criarLoginMotorista
 * (@RequestBody RequestLoginMotorista obj) throws IOException{ return
 * service.criarLoginMotorista(obj); }
 * 
 * @PostMapping (value="/consultar-aprovacao") public int consultarAprovacao
 * (@RequestBody RequestLoginMotorista obj) throws IOException{ return
 * service.consultarAprovacao(obj); }
 * 
 * 
 * 
 * @PutMapping(value = "/atualizar") public ResponseEntity<Motorista>
 * atualizarMotorista (@RequestBody Motorista obj){
 * System.out.println("entrou no put pelo menos"); obj =
 * service.atualizarMotorista(obj); System.out.println("entrou no put"); return
 * ResponseEntity.ok().body(obj); }
 * 
 * 
 * 
 * 
 * 
 * @GetMapping(value = "/anuncio-resumo/{id}")
 * 
 * public ResponseEntity<AnuncioResumoCard>
 * findAllProjectedByIdServico(@PathVariable Long id){
 * System.out.println("ENTROU 1"); AnuncioResumoCard obj =
 * service.findAllProjectedByIdServico(id); System.out.println("ENTROU 2");
 * 
 * return ResponseEntity.ok().body(obj); }
 * 
 * 
 * 
 * @PostMapping (value = "/filtrar") public
 * ResponseEntity<List<AnunciosFiltrados>> filtrar (@RequestBody AnuncioFiltro
 * obj){ System.out.println("resource insert:");
 * System.out.println(obj.toString()); List<AnunciosFiltrados> listaAnuncios =
 * service.filtrar(obj);
 * 
 * 
 * URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
 * .buildAndExpand(obj.getClass()).toUri(); return
 * ResponseEntity.created(uri).body(listaAnuncios); } /*
 * 
 * 
 * /*
 * 
 * @PostMapping (value = "/cliente") public ResponseEntity<Motorista>
 * insertCliente (@RequestBody Motorista obj){
 * 
 * System.out.println(obj.toString()); obj = service.insertCliente(obj); URI uri
 * = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
 * .buildAndExpand(obj.getId()).toUri(); return
 * ResponseEntity.created(uri).body(obj); }
 * 
 * 
 * 
 * }
 */