package com.example.blog.models

import com.google.gson.annotations.SerializedName

class Blog(
    @SerializedName("id"                            ) var id                          : Int?              = null,
    @SerializedName("date"                          ) var date                        : String?           = null,
    @SerializedName("date_gmt"                      ) var dateGmt                     : String?           = null,
    @SerializedName("guid"                          ) var guid                        : Guid?             = Guid(),
    @SerializedName("modified"                      ) var modified                    : String?           = null,
    @SerializedName("modified_gmt"                  ) var modifiedGmt                 : String?           = null,
    @SerializedName("slug"                          ) var slug                        : String?           = null,
    @SerializedName("status"                        ) var status                      : String?           = null,
    @SerializedName("type"                          ) var type                        : String?           = null,
    @SerializedName("link"                          ) var link                        : String?           = null,
    @SerializedName("title"                         ) var title                       : Title?            = Title(),
    @SerializedName("content"                       ) var content                     : Content?          = Content(),
    @SerializedName("excerpt"                       ) var excerpt                     : Excerpt?          = Excerpt(),
    @SerializedName("author"                        ) var author                      : Int?              = null,
    @SerializedName("featured_media"                ) var featuredMedia               : Int?              = null,
    @SerializedName("comment_status"                ) var commentStatus               : String?           = null,
    @SerializedName("ping_status"                   ) var pingStatus                  : String?           = null,
    @SerializedName("sticky"                        ) var sticky                      : Boolean?          = null,
    @SerializedName("template"                      ) var template                    : String?           = null,
    @SerializedName("format"                        ) var format                      : String?           = null,


    )


data class Guid (

    @SerializedName("rendered" ) var rendered : String? = null

)
data class Title (

    @SerializedName("rendered" ) var rendered : String? = null

)
data class Content (

    @SerializedName("rendered"  ) var rendered  : String?  = null,
    @SerializedName("protected" ) var protected : Boolean? = null

)
data class Excerpt (

    @SerializedName("rendered"  ) var rendered  : String?  = null,
    @SerializedName("protected" ) var protected : Boolean? = null

)
data class ImageGeneratorSettings (

    @SerializedName("template" ) var template : String?  = null,
    @SerializedName("enabled"  ) var enabled  : Boolean? = null

)
data class JetpackSocialOptions (

    @SerializedName("image_generator_settings" ) var imageGeneratorSettings : ImageGeneratorSettings? = ImageGeneratorSettings()

)
data class Meta (

    @SerializedName("jetpack_post_was_ever_published"                 ) var jetpackPostWasEverPublished                : Boolean?              = null,
    @SerializedName("_jetpack_newsletter_access"                      ) var JetpackNewsletterAccess                    : String?               = null,
    @SerializedName("_jetpack_dont_email_post_to_subs"                ) var JetpackDontEmailPostToSubs                 : Boolean?              = null,
    @SerializedName("_jetpack_newsletter_tier_id"                     ) var JetpackNewsletterTierId                    : Int?                  = null,
    @SerializedName("_jetpack_memberships_contains_paywalled_content" ) var JetpackMembershipsContainsPaywalledContent : Boolean?              = null,
    @SerializedName("_jetpack_memberships_contains_paid_content"      ) var JetpackMembershipsContainsPaidContent      : Boolean?              = null,
    @SerializedName("footnotes"                                       ) var footnotes                                  : String?               = null,
    @SerializedName("jetpack_publicize_message"                       ) var jetpackPublicizeMessage                    : String?               = null,
    @SerializedName("jetpack_publicize_feature_enabled"               ) var jetpackPublicizeFeatureEnabled             : Boolean?              = null,
    @SerializedName("jetpack_social_post_already_shared"              ) var jetpackSocialPostAlreadyShared             : Boolean?              = null,
    @SerializedName("jetpack_social_options"                          ) var jetpackSocialOptions                       : JetpackSocialOptions? = JetpackSocialOptions()

)
data class Self (

    @SerializedName("href" ) var href : String? = null

)
data class Collection (

    @SerializedName("href" ) var href : String? = null

)
data class About (

    @SerializedName("href" ) var href : String? = null

)
data class Author (

    @SerializedName("embeddable" ) var embeddable : Boolean? = null,
    @SerializedName("href"       ) var href       : String?  = null

)
data class Replies (

    @SerializedName("embeddable" ) var embeddable : Boolean? = null,
    @SerializedName("href"       ) var href       : String?  = null

)
