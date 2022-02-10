import pygame
from pygame import *
from animal import Animal
import game_config as gc
from time import sleep
pygame.init()
display.set_caption("find the similar :) ")
screen=display.set_mode((512,512))
matched=image.load("match.png")
screen.blit(matched,(0,0))
display.flip()
running = True
current_images=[]
def find_index(x,y):
    row=y//gc.Image_size
    col=x//gc.Image_size
    index=row*gc.Num_of_til_on_side+col
    return index
tiles=[Animal(i) for i in range(0,gc.Num_of_til_on_total)]
while running:
    current_events=event.get()
    for e in current_events:
        if e.type == pygame.QUIT:
            running = False
        if e.type ==pygame.MOUSEBUTTONDOWN:
            mouse_x,mouse_y=pygame.mouse.get_pos()
            index=find_index(mouse_x,mouse_y)
            if index not in current_images:
                current_images.append(index)
            if(len(current_images)>2):
                current_images=current_images[1:]

    screen.fill((255,255,255))
    for i,tile in enumerate(tiles):
        image_i=tile.image if i in current_images else tile.box
        if not tile.skip:
            screen.blit(image_i ,(tile.col *gc.Image_size+gc.Margin,tile.row*gc.Image_size+gc.Margin))
    display.flip()
    skip_total=0
    if len(current_images)==2:
        index1,index2=current_images
        if(tiles[index1].name==tiles[index2].name):
            tiles[index1].skip=True
            tiles[index2].skip=True
            sleep(0.4)
            screen.blit(matched,(0,0))
            display.flip()
            sleep(0.4)
            current_images=[]
            skip_total+=2
    if skip_total==8:
        running=False
print("i Hope you happy") 