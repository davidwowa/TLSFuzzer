package tech.cybersword.tls.fuzzer.generator;

public interface ITLSExtensionData {

	public byte[] server_name_RFC6066_RFC9261();

	public byte[] max_fragment_length_RFC6066_RFC8449();

	public byte[] client_certificate_url_RFC6066();

	public byte[] trusted_ca_keys_RFC6066();

	public byte[] truncated_hmac_RFC6066_IESG();

	public byte[] status_request_RFC6066();

	public byte[] user_mapping_RFC4681();

	public byte[] client_authz_RFC5878();

	public byte[] server_authz_RFC5878();

	public byte[] cert_type_RFC6091();

	public byte[] supported_groups_renamed_from_elliptic_curves_RFC8422_RFC7919();

	public byte[] ec_point_formats_RFC8422();

	public byte[] srp_RFC5054();

	public byte[] signature_algorithms_RFC8446();

	public byte[] use_srtp_RFC5764();

	public byte[] heartbeat_RFC6520();

	public byte[] application_layer_protocol_negotiation_RFC7301();

	public byte[] status_request_v2_RFC6961();

	public byte[] signed_certificate_timestamp_RFC6962();

	public byte[] client_certificate_type_RFC7250();

	public byte[] server_certificate_type_RFC7250();

	public byte[] padding_RFC7685();

	public byte[] encrypt_then_mac_RFC7366();

	public byte[] extended_master_secret_RFC7627();

	public byte[] token_binding_RFC8472();

	public byte[] cached_info_RFC7924();

	public byte[] tls_lts_draft_gutmann_tls_lts();

	public byte[] compress_certificate_RFC8879();

	public byte[] record_size_limit_RFC8449();

	public byte[] pwd_protect_RFC8492();

	public byte[] pwd_clear_RFC8492();

	public byte[] password_salt_RFC8492();

	public byte[] ticket_pinning_RFC8672();

	public byte[] tls_cert_with_extern_psk_RFC8773();

	public byte[] delegated_credentials_RFC_ietf_tls_subcerts_15();

	public byte[] session_ticket_renamed_from_SessionTicket_TLS_RFC5077_RFC8447();

	public byte[] TLMSP();

	public byte[] TLMSP_proxying();

	public byte[] TLMSP_delegate();

	public byte[] supported_ekt_ciphers_RFC8870();

	public byte[] pre_shared_key_RFC8446();

	public byte[] early_data_RFC8446();

	public byte[] supported_versions_RFC8446();

	public byte[] cookie_RFC8446();

	public byte[] psk_key_exchange_modes_RFC8446();

	public byte[] certificate_authorities_RFC8446();

	public byte[] oid_filters_RFC8446();

	public byte[] post_handshake_auth_RFC8446();

	public byte[] signature_algorithms_cert_RFC8446();

	public byte[] key_share_RFC8446();

	public byte[] transparency_info_RFC9162();

	public byte[] connection_id_deprecated_RFC9146();

	public byte[] connection_id_RFC9146();

	public byte[] external_id_hash_RFC8844();

	public byte[] external_session_id_RFC8844();

	public byte[] quic_transport_parameters_RFC9001();

	public byte[] ticket_request_RFC9149();

	public byte[] dnssec_chain_RFC9102_RFC_Errata_6860();
}