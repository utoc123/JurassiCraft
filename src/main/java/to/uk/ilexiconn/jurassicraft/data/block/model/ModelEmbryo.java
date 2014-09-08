package to.uk.ilexiconn.jurassicraft.data.block.model;

import ilexiconn.llib.client.model.MowzieModelBase;
import ilexiconn.llib.client.model.MowzieModelRenderer;
import to.uk.ilexiconn.jurassicraft.data.tile.TileCultivate;

public class ModelEmbryo extends MowzieModelBase
{
    public MowzieModelRenderer[] shapes = new MowzieModelRenderer[9];

    public ModelEmbryo()
    {
        textureWidth = 128;
        textureHeight = 128;

        shapes[0] = new MowzieModelRenderer(this, 30, 0); //Body
        shapes[0].addBox(-1f, 0f, -1f, 2, 5, 3);
        shapes[0].setRotationPoint(0f, 0f, 0f);
        setRotationAngle(shapes[0], 0.1745329f, 0f, 0f);
        shapes[1] = new MowzieModelRenderer(this, 22, 0); //Neck
        shapes[1].addBox(-0.5f, 0f, 0f, 1, 3, 2);
        shapes[1].setRotationPoint(0f, -0.5f, -2f);
        setRotationAngle(shapes[1], 0.8726646f, 0f, 0f);
        shapes[2] = new MowzieModelRenderer(this, 0, 0); //Head
        shapes[2].addBox(0f, -0.5f, 0.3f, 2, 2, 3);
        shapes[2].setRotationPoint(-1f, -2.5f, -1f);
        setRotationAngle(shapes[2], -1.972222f, 0f, 0f);
        shapes[3] = new MowzieModelRenderer(this, 52, 0); //Tail1
        shapes[3].addBox(0f, 1f, 0f, 1, 4, 1);
        shapes[3].setRotationPoint(-0.5f, 6f, 1.7f);
        setRotationAngle(shapes[3], -0.6108652f, 0f, 0f);
        shapes[4] = new MowzieModelRenderer(this, 42, 0); //Tail2
        shapes[4].addBox(0f, 0f, 0f, 2, 3, 2);
        shapes[4].setRotationPoint(-1f, 4f, 0.8f);
        setRotationAngle(shapes[4], -0.2617994f, 0f, 0f);
        shapes[5] = new MowzieModelRenderer(this, 20, 8); //ArmTop1
        shapes[5].addBox(0f, 0f, 0f, 1, 2, 1);
        shapes[5].setRotationPoint(1f, 0.5f, -0.5f);
        setRotationAngle(shapes[5], -0.3490659f, 0f, 0f);
        shapes[6] = new MowzieModelRenderer(this, 20, 13); //ArmTop2
        shapes[6].addBox(0f, 0f, 0f, 1, 2, 1);
        shapes[6].setRotationPoint(-2f, 0.5f, -0.5f);
        setRotationAngle(shapes[6], -0.3490659f, 0f, 0f);
        shapes[7] = new MowzieModelRenderer(this, 44, 8); //ArmBottom1
        shapes[7].addBox(0f, 0f, 0f, 1, 3, 1);
        shapes[7].setRotationPoint(1f, 3f, 0.5f);
        setRotationAngle(shapes[7], -0.4363323f, 0f, 0f);
        shapes[8] = new MowzieModelRenderer(this, 44, 14); //ArmBottom2
        shapes[8].addBox(0f, 0f, 0f, 1, 3, 1);
        shapes[8].setRotationPoint(-2f, 3f, 0.5f);
        setRotationAngle(shapes[8], -0.4363323f, 0f, 0f);

        addChildTo(shapes[5], shapes[0]);
        addChildTo(shapes[6], shapes[0]);
        addChildTo(shapes[7], shapes[0]);
        addChildTo(shapes[8], shapes[0]);
        addChildTo(shapes[3], shapes[4]);
        addChildTo(shapes[4], shapes[0]);

        for (MowzieModelRenderer shape : shapes)
        {
            shape.setTextureSize(128, 128);
            shape.setInitValuesToCurrentPose();
        }
    }

    public void render(TileCultivate tile)
    {
        shapes[0].render(0.0625f);
        shapes[1].render(0.0625f);
        shapes[2].render(0.0625f);

        tailSwing(shapes, 0.13f, 0.1f, 0, tile.animationTick);
    }

    public void setRotationAngle(MowzieModelRenderer box, float x, float y, float z)
    {
        box.initRotateAngleX = x;
        box.initRotateAngleY = y;
        box.initRotateAngleZ = z;
    }
}