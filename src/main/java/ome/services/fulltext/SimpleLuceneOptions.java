/*
 *   $Id$
 *
 *   Copyright 2009 Glencoe Software, Inc. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */

package ome.services.fulltext;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.Field.TermVector;
import org.hibernate.search.bridge.LuceneOptions;

/**
 * Implementation of {@link LuceneOptions} which takes an existing instance and
 * possible overrides for each of the values.
 *
 * @author Josh Moore, josh at glencoesoftware.com
 * @since 3.0-Beta3
 */
@Deprecated
public class SimpleLuceneOptions implements LuceneOptions {

    private final LuceneOptions delegate;

    private final Float boost;

    private final Field.Index index;

    private final Field.Store store;

    public SimpleLuceneOptions(LuceneOptions opts, Float boost) {
        this(opts, boost, null, null);
    }

    public SimpleLuceneOptions(LuceneOptions opts, Field.Store store) {
        this(opts, null, null, store);
    }

    public SimpleLuceneOptions(LuceneOptions opts, Index index, Store store) {
        this(opts, null, index, store);
    }

    public SimpleLuceneOptions(LuceneOptions opts, Float boost,
            Field.Index index, Field.Store store) {
        this.delegate = opts;
        this.boost = boost;
        this.store = store;
        this.index = index;
    }

    @Override
    public Float getBoost() {
        if (boost != null) {
            return boost;
        }
        return delegate.getBoost();
    }

    @Override
    public String indexNullAs() {
        return null;
    }

    @Override
    public Index getIndex() {
        if (index != null) {
            return index;
        }
        return delegate.getIndex();
    }

    @Override
    public Store getStore() {
        if (store != null) {
            return store;
        }
        return delegate.getStore();
    }

    @Override
    public TermVector getTermVector() {
        return delegate.getTermVector();
    }


    @Override
    public void addFieldToDocument(String fieldName, String indexedString, Document document) {

    }

    @Override
    public void addNumericFieldToDocument(String fieldName, Object numericValue, Document document) {

    }

    @Override
    public boolean isCompressed() {
        return false;
    }


}