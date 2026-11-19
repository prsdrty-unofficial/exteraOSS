package com.exteragram.messenger.plugins.catalog;

import com.exteragram.messenger.plugins.PluginsConstants;
import com.exteragram.messenger.plugins.catalog.db.CatalogEntryEntity;
import com.exteragram.messenger.plugins.catalog.db.CatalogEntryWithMetadata;
import com.exteragram.messenger.plugins.catalog.db.PluginMetadataEntity;
import com.google.android.gms.cast.MediaTrack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.url._UrlKt;
import retrofit2.Utils$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: /home/sokolovsky/ex/03_res/full/classes4.dex */
public final class CatalogPlugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String caption;
    private final int date;
    private final long documentId;
    private final int entryId;
    private final String fileName;
    private final PluginMetadataEntity metadata;
    private final int publishedAt;
    private final long repositoryId;
    private final long size;
    private final int updatedAt;
    private final int views;

    public CatalogPlugin(long j, int i, int i2, int i3, long j2, String str, long j3, String str2, PluginMetadataEntity pluginMetadataEntity, int i4, int i5) {
        this.repositoryId = j;
        this.entryId = i;
        this.date = i2;
        this.updatedAt = i3;
        this.documentId = j2;
        this.fileName = str;
        this.size = j3;
        this.caption = str2;
        this.metadata = pluginMetadataEntity;
        this.views = i4;
        this.publishedAt = i5;
    }

    public final long getRepositoryId() {
        return this.repositoryId;
    }

    public final int getEntryId() {
        return this.entryId;
    }

    public final int getDate() {
        return this.date;
    }

    public final int getUpdatedAt() {
        return this.updatedAt;
    }

    public final long getDocumentId() {
        return this.documentId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final PluginMetadataEntity getMetadata() {
        return this.metadata;
    }

    public final int getViews() {
        return this.views;
    }

    public final int getPublishedAt() {
        return this.publishedAt;
    }

    public final String getPluginId() {
        PluginMetadataEntity pluginMetadataEntity = this.metadata;
        if (pluginMetadataEntity != null) {
            if (pluginMetadataEntity.getError() != null) {
                pluginMetadataEntity = null;
            }
            if (pluginMetadataEntity != null) {
                return pluginMetadataEntity.getPluginId();
            }
        }
        return null;
    }

    public final boolean isPending() {
        return this.metadata == null;
    }

    public final boolean isFailed() {
        PluginMetadataEntity pluginMetadataEntity = this.metadata;
        return (pluginMetadataEntity != null ? pluginMetadataEntity.getError() : null) != null;
    }

    public final List<PluginCategory> getCategories() {
        PluginCategory.Companion companion = PluginCategory.INSTANCE;
        PluginMetadataEntity pluginMetadataEntity = this.metadata;
        String categories = null;
        if (pluginMetadataEntity != null) {
            if (pluginMetadataEntity.getError() != null) {
                pluginMetadataEntity = null;
            }
            if (pluginMetadataEntity != null) {
                categories = pluginMetadataEntity.getCategories();
            }
        }
        return companion.parse(categories);
    }



    public static final Companion Companion = new Companion();

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CatalogPlugin from(CatalogEntryWithMetadata row) {
            CatalogEntryEntity entry = row.getEntry();
            return new CatalogPlugin(entry.getRepositoryId(), entry.getEntryId(), entry.getDate(), entry.getUpdatedAt(), entry.getDocumentId(), entry.getFileName(), entry.getSize(), entry.getCaption(), row.getMetadata(), entry.getViews(), entry.getDate());
        }

        public final List<CatalogPlugin> latestVersions(List<CatalogPlugin> plugins) {
            final Comparator comparator = new Comparator() { // from class: com.exteragram.messenger.plugins.catalog.CatalogPlugin$Companion$latestVersions$$inlined$compareByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(Object t, Object t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((CatalogPlugin) t2).getUpdatedAt()), Integer.valueOf(((CatalogPlugin) t).getUpdatedAt()));
                }
            };
            List<CatalogPlugin> listSortedWith = CollectionsKt.sortedWith(plugins, new Comparator() { // from class: com.exteragram.messenger.plugins.catalog.CatalogPlugin$Companion$latestVersions$$inlined$thenByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(Object t, Object t2) {
                    int iCompare = comparator.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Integer.valueOf(((CatalogPlugin) t2).getEntryId()), Integer.valueOf(((CatalogPlugin) t).getEntryId()));
                }
            });
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSortedWith) {
                if (((CatalogPlugin) obj).getPluginId() != null) {
                    arrayList.add(obj);
                }
            }
            HashSet hashSet = new HashSet();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                hashSet.add(((CatalogPlugin) obj2).getFileName().toLowerCase(Locale.ROOT));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (CatalogPlugin catalogPlugin : listSortedWith) {
                String pluginId = catalogPlugin.getPluginId();
                if (pluginId == null) {
                    String fileName = catalogPlugin.getFileName();
                    Locale locale = Locale.ROOT;
                    if (!hashSet.contains(fileName.toLowerCase(locale))) {
                        pluginId = "file:" + catalogPlugin.getFileName().toLowerCase(locale);
                    }
                }
                Object arrayList2 = linkedHashMap.get(pluginId);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(pluginId, arrayList2);
                }
                ((ArrayList) arrayList2).add(catalogPlugin);
            }
            Collection collectionValues = linkedHashMap.values();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                ArrayList arrayList4 = (ArrayList) it.next();
                CatalogPlugin catalogPlugin2 = (CatalogPlugin) CollectionsKt.first((List) arrayList4);
                long repositoryId = catalogPlugin2.getRepositoryId();
                int entryId = catalogPlugin2.getEntryId();
                int date = catalogPlugin2.getDate();
                int updatedAt = catalogPlugin2.getUpdatedAt();
                long documentId = catalogPlugin2.getDocumentId();
                String fileName2 = catalogPlugin2.getFileName();
                long size2 = catalogPlugin2.getSize();
                String caption = catalogPlugin2.getCaption();
                PluginMetadataEntity metadata = catalogPlugin2.getMetadata();
                Iterator it2 = arrayList4.iterator();
                if (!it2.hasNext()) {
                    android.support.v4.media.session.MediaSessionCompat$$ExternalSyntheticThrowCCEIfNotNull0.m(new Object[]{});
                    return null;
                }
                int views = ((CatalogPlugin) it2.next()).getViews();
                while (it2.hasNext()) {
                    Iterator it3 = it;
                    int views2 = ((CatalogPlugin) it2.next()).getViews();
                    if (views < views2) {
                        views = views2;
                    }
                    it = it3;
                }
                Iterator it4 = it;
                Iterator it5 = arrayList4.iterator();
                if (!it5.hasNext()) {
                    android.support.v4.media.session.MediaSessionCompat$$ExternalSyntheticThrowCCEIfNotNull0.m(new Object[]{});
                    return null;
                }
                int date2 = ((CatalogPlugin) it5.next()).getDate();
                while (it5.hasNext()) {
                    int date3 = ((CatalogPlugin) it5.next()).getDate();
                    if (date2 > date3) {
                        date2 = date3;
                    }
                }
                arrayList3.add(new CatalogPlugin(repositoryId, entryId, date, updatedAt, documentId, fileName2, size2, caption, metadata, views, date2));
                it = it4;
            }
            return arrayList3;
        }
    }
}
