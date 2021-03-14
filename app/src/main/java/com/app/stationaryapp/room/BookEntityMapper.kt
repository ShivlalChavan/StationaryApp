package com.app.stationaryapp.room

import com.app.stationaryapp.model.Book
import com.app.stationaryapp.room.entity.BookEntity
import com.app.stationaryapp.utils.EntityMapper
import javax.inject.Inject

class BookEntityMapper
@Inject
constructor():EntityMapper<BookEntity,Book>{

    override fun mapFromEntity(entity: BookEntity): Book {
        return Book(
            bid = entity.bid.toString(),
            title = entity.title,
            ratings = entity.ratings,
            price = entity.price,
            image =  entity.image,
            authorName = entity.authorName,
            description = entity.description,
            status = entity.status,
            category = entity.category,
            pages = entity.pages,
            __v = entity.__v,
            createdAt = entity.createdAt,
            bookid = entity.bookid
        )
    }

    override fun mapToEntity(domainModel: Book): BookEntity {
        return BookEntity(
            bid = domainModel.bid.toInt(),
            title =  domainModel.title,
            category = domainModel.category,
            pages = domainModel.pages,
            description = domainModel.description,
            authorName = domainModel.authorName,
            status = domainModel.status,
            price = domainModel.price,
            image = domainModel.image,
            ratings = domainModel.ratings,
            createdAt = domainModel.createdAt,
           __v = domainModel.__v,
            bookid = domainModel.bookid
        )
    }

    fun mapFromEntityList(entityList: List<BookEntity>):List<Book>{
        return entityList.map { mapFromEntity(it)}
    }





}



