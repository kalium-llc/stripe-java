package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.RequestOptions;

import java.util.Map;

/**
 * Common interface for Stripe objects that can store metadata.
 */
public interface MetadataStore<T> {
	Map<String, String> getMetadata();

	MetadataStore<T> update(Map<String, Object> params) throws AuthenticationException, InvalidRequestException,
		APIConnectionException, CardException, APIException;

	MetadataStore<T> update(Map<String, Object> params, RequestOptions options) throws AuthenticationException, InvalidRequestException,
		APIConnectionException, CardException, APIException;
}
