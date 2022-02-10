import os
import game_config as gc
from pygame import *
import random
animals_count=dict((a,0) for a in gc.images_file)
def available_animal():
    return [a for a, c in animals_count.items() if c<2]
class Animal:
    def __init__ (self,index):
        self.index=index
        self.row=index//gc.Num_of_til_on_side
        self.col=index % gc.Num_of_til_on_side
        self.name=random.choice(available_animal())
        animals_count[self.name]+=1
        self.image_path = os.path.join(gc.Asset_dir,self.name)
        self.image=image.load(self.image_path)
        self.image=transform.scale(self.image,(gc.Image_size-2*gc.Margin,gc.Image_size-2*gc.Margin))
        self.box=self.image.copy()
        self.box.fill((200,200,200))
        self.skip=False

