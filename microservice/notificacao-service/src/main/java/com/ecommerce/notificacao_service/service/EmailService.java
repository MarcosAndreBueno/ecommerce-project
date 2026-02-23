package com.ecommerce.notificacao_service.service;

import com.ecommerce.notificacao_service.model.DTO.ProdutoRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ecommerce.notificacao_service.service.enums.EmailTemplates.PAGAMENTO_CONFIRMACAO_TEMPLATE;
import static com.ecommerce.notificacao_service.service.enums.EmailTemplates.PEDIDO_CONFIRMACAO_TEMPLATE;
import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void enviarEmailConfirmacaoPagamento(
            String emailDestinatario,
            String clienteNomeCompleto,
            BigDecimal valorTotal,
            String pedidoReferencias
    ) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        messageHelper.setFrom("contato@ecommerce.com");

        final String nomeTemplate = PAGAMENTO_CONFIRMACAO_TEMPLATE.getTemplate();

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("clienteNomeCompleto", clienteNomeCompleto);
        parametros.put("valorTotal", valorTotal);
        parametros.put("pedidoReferencias", pedidoReferencias);

        Context contexto = new Context();
        contexto.setVariables(parametros);
        messageHelper.setSubject(PAGAMENTO_CONFIRMACAO_TEMPLATE.getAssunto());

        try {
            String htmlTemplate = templateEngine.process(nomeTemplate, contexto);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(emailDestinatario);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email enviado com sucesso para %s com o template %s ", emailDestinatario, nomeTemplate));
        } catch (MessagingException e) {
            log.warn("AVISO - falha ao evniar email para {} com template {} ", emailDestinatario, nomeTemplate);
        }

    }

    @Async
    public void enviarEmailConfirmacaoPedido(
            String emailDestinatario,
            String clienteNomeCompleto,
            BigDecimal valorTotal,
            String pedidoReferencias,
            List<ProdutoRequest> produtos
    ) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        messageHelper.setFrom("contato@ecommerce.com");

        final String nomeTemplate = PEDIDO_CONFIRMACAO_TEMPLATE.getTemplate();

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("clienteNomeCompleto", clienteNomeCompleto);
        parametros.put("valorTotal", valorTotal);
        parametros.put("pedidoReferencias", pedidoReferencias);
        parametros.put("produtos", produtos);

        Context contexto = new Context();
        contexto.setVariables(parametros);
        messageHelper.setSubject(PEDIDO_CONFIRMACAO_TEMPLATE.getAssunto());

        try {
            String htmlTemplate = templateEngine.process(nomeTemplate, contexto);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(emailDestinatario);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email enviado com sucesso para %s com o template %s ", emailDestinatario, nomeTemplate));
        } catch (MessagingException e) {
            log.warn("AVISO - falha ao enviar email para {} com template {} ", emailDestinatario, nomeTemplate);
        }

    }
}
