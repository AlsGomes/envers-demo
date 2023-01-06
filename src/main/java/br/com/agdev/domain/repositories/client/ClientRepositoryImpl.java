package br.com.agdev.domain.repositories.client;

import java.util.List;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Repository;

import br.com.agdev.domain.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ClientRepositoryImpl implements ClientAuditsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@Override
	public List<ClientAudit> getClientAudits() {
		
		AuditReader reader = AuditReaderFactory.get(entityManager);
		AuditQuery query = reader.createQuery().forRevisionsOfEntity(Client.class, false, true);
		query.addOrder(AuditEntity.revisionNumber().desc());
		List result = query.getResultList();

		List<ClientAudit> audits = result.stream()
				.map(obj -> revisionMapper((Object[]) obj))
				.toList();

		return audits;
	}

	private ClientAudit revisionMapper(Object[] parts) {
		Client client = (Client) parts[0];
		DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) parts[1];
		String operation = parts[2].toString();
		return new ClientAudit(client, revisionEntity, operation);
	}
}
