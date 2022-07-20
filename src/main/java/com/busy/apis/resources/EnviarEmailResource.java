/*
 * package com.busy.apis.resources;
 * 
 * import javax.validation.ValidationException;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.mail.SimpleMailMessage; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.validation.BindingResult; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.busy.apis.entities.EnviarEmail; import
 * com.busy.apis.entities.Transportadora; import
 * com.busy.apis.repositories.TransportadoraRepository;
 * 
 * @RestController
 * 
 * @RequestMapping(value = "/enviar-email") public class EnviarEmailResource {
 * 
 * @Autowired public JavaMailSender mailSender;
 * 
 * @Autowired private TransportadoraRepository repositoryTransportadora;
 * 
 * @Autowired private EmailConfig emailConfig;
 * 
 * public void EnviarEmailController(EmailConfig emailConfig) { this.emailConfig
 * = emailConfig; }
 * 
 * 
 * @PostMapping public String sendEnviarEmail(@RequestBody EnviarEmail
 * enviarEmail, BindingResult bindingResult) { System.out.println("email0");
 * 
 * if (bindingResult.hasErrors()) { System.out.println("email erro");
 * 
 * throw new ValidationException("A requisi��o esta mal formada"); }
 * 
 * System.out.println("email1"+this.emailConfig.getHost()); // Create a mail
 * sender JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
 * mailSender.setHost(this.emailConfig.getHost());
 * System.out.println("email3222");
 * 
 * mailSender.setPort(this.emailConfig.getPort()); System.out.println("email2");
 * 
 * mailSender.setUsername(this.emailConfig.getUsername());
 * mailSender.setPassword(this.emailConfig.getPassword());
 * System.out.println("email3");
 * 
 * try {
 * 
 * // Create an email instance SimpleMailMessage mailMessage = new
 * SimpleMailMessage();
 * 
 * mailMessage.setFrom("noreply@alocaja.portaldotransportador.com");
 * 
 * if (enviarEmail.getTipoEmail() == 1) { Transportadora transportadora = new
 * Transportadora();
 * 
 * transportadora = repositoryTransportadora.findByCnpj(enviarEmail.getCnpj());
 * var sendTo = transportadora.getEmail(); mailMessage.setTo(sendTo);
 * mailMessage.setSubject("AlocaJa - Motorista Pendente");
 * mailMessage.setText("Prezado(a), " + transportadora.getNome() + "!" + "\n" +
 * "\n" +
 * "A transportadora tem um novo motorista cadastrado querendo se afiliar! Aprove ou reprove pela plataforma do alocaja:"
 * + "\n" + "\n" + "Nome: " + enviarEmail.getNomeMotorista() + "\n" + "CNH: " +
 * enviarEmail.getCnhMotorista() + "\n" + "Celular: " +
 * enviarEmail.getTelefoneMotorista()
 * 
 * + "\n" + "\n" + "Atenciosamente," + "\n" + "Equipe do AlocaJa");
 * 
 * } else if (enviarEmail.getTipoEmail() == 10) {
 * 
 * mailMessage.setTo(enviarEmail.getEmail());
 * mailMessage.setSubject("AlocaJa - Bem vindo!");
 * mailMessage.setText("Prezado(a), " + enviarEmail.getNomeMotorista() + "!" +
 * "\n"+
 * "Seu pedido para fazer parte do portal foi aprovado, segue dados de acesso e transportadora:"
 * + "\n" + enviarEmail.getMensagem()
 * 
 * ); System.out.println("email5"); } else if (enviarEmail.getTipoEmail() == 11)
 * {
 * 
 * mailMessage.setTo(enviarEmail.getEmail());
 * mailMessage.setSubject("AlocaJa - Pedido negado!");
 * mailMessage.setText("Prezado(a), " + enviarEmail.getNomeMotorista() + "!" +
 * "\n"+ "Seu pedido para fazer parte do portal foi negado!"+ "\n" +
 * enviarEmail.getMensagem()
 * 
 * ); System.out.println("email5"); }else {
 * 
 * mailMessage.setTo(enviarEmail.getEmail());
 * mailMessage.setSubject("AlocaJa - Bem vindo!");
 * mailMessage.setText("Prezado(a), " + enviarEmail.getNomeMotorista() + "!" +
 * "\n" +
 * "Recebemos seu pedido para fazer parte da AlocaJa! As transportadoras escolhidas foram notificadas sobre seu pedido e assim que for aprovado deve-se receber um email para acessar o aplicativo do portal do transportador!"
 * + "\n" + "\n" + "Seja bem vindo(a)!" + "\n" + "\n" + "Atenciosamente," + "\n"
 * + "Equipe do AlocaJa"); System.out.println("email5"); }
 * 
 * // Send mail
 * 
 * mailSender.send(mailMessage); System.out.println("email: sucesso");
 * 
 * return "true"; } catch (RuntimeException e) { e.printStackTrace(); throw new
 * ValidationException("Erro ao enviar email!");
 * 
 * }
 * 
 * }
 * 
 * }
 */