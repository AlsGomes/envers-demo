package br.com.agdev.domain.repositories.client;

import org.hibernate.envers.DefaultRevisionEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.agdev.domain.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientAudit {
	
	private Client client;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private DefaultRevisionEntity revision;
	
	private String operation;
}
